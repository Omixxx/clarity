import argparse
import logging

import javalang

METHOD_NAME_KEY = "method_name"
METHOD_BODY_KEY = "body"
START_LINE_KEY = "startline"
END_LINE_KEY = "endline"


def __get_method_start_end(tree, method_node):
    startpos = None
    endpos = None
    startline = None
    endline = None
    for path, node in tree:
        if startpos is not None and method_node not in path:
            endpos = node.position
            endline = node.position.line if node.position is not None else None
            break
        if startpos is None and node == method_node:
            startpos = node.position
            startline = node.position.line if node.position is not None else None
    return startpos, endpos, startline, endline


def __get_method_text(
    startpos, endpos, startline, endline, last_endline_index, codelines
):
    if startpos is None:
        return "", None, None, None
    else:
        startline_index = startline - 1
        endline_index = endline - 1 if endpos is not None else None

        # 1. check for and fetch annotations
        if last_endline_index is not None:
            for line in codelines[(last_endline_index + 1) : (startline_index)]:
                if "@" in line:
                    startline_index = startline_index - 1
        meth_text = "<ST>".join(codelines[startline_index:endline_index])
        meth_text = meth_text[: meth_text.rfind("}") + 1]

        # 2. remove trailing rbrace for last methods & any external content/comments
        # if endpos is None and
        if not abs(meth_text.count("}") - meth_text.count("{")) == 0:
            # imbalanced braces
            brace_diff = abs(meth_text.count("}") - meth_text.count("{"))

            for _ in range(brace_diff):
                meth_text = meth_text[: meth_text.rfind("}")]
                meth_text = meth_text[: meth_text.rfind("}") + 1]

        meth_lines = meth_text.split("<ST>")
        meth_text = "".join(meth_lines)
        last_endline_index = startline_index + (len(meth_lines) - 1)

        return (
            meth_text,
            (startline_index + 1),
            (last_endline_index + 1),
            last_endline_index,
        )


def extract_methods(file_path: str) -> list[dict[str, str]]:
    logging.getLogger().setLevel(logging.INFO)
    with open(file_path, "r") as file:
        codelines = file.readlines()
        code_text = "".join(codelines)

    tree = javalang.parse.parse(code_text)
    lex = None
    methods = list()
    for _, method_node in tree.filter(javalang.parser.tree.MethodDeclaration):
        startpos, endpos, startline, endline = __get_method_start_end(tree, method_node)
        method_text, startline, endline, lex = __get_method_text(
            startpos, endpos, startline, endline, lex, codelines
        )
        methods.append(
            {
                METHOD_NAME_KEY: method_node.name,
                METHOD_BODY_KEY: method_text,
                START_LINE_KEY: startline,
                END_LINE_KEY: endline,
            }
        )
    return methods


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Download GitHub repositories")
    parser.add_argument(
        "java_file",
        metavar="java_file.java",
        type=str,
        nargs=1,
        help="java file on which method will be extracted",
    )
    args = parser.parse_args()
    file_path = args.java_file.pop()
    extract_methods(file_path)
