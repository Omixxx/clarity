import argparse
import logging

import javalang


def __get_start_end_for_node(node_to_find, tree):
    start = None
    end = None
    for path, node in tree:
        if start is not None and node_to_find not in path:
            end = node.position
            return start, end
        if start is None and node == node_to_find:
            start = node.position
    return start, end


def __get_string(start, end, data):
    if start is None:
        return ""

    # positions are all offset by 1. e.g. first line -> lines[0], start.line = 1
    end_pos = None

    if end is not None:
        end_pos = end.line - 1

    lines = data.splitlines(True)
    string = "".join(lines[start.line : end_pos])
    string = lines[start.line - 1] + string

    # When the method is the last one, it will contain a additional brace
    if end is None:
        left = string.count("{")
        right = string.count("}")
        if right - left == 1:
            p = string.rfind("}")
            string = string[:p]

    return string


def extract_methods(file_path: str) -> list[str]:
    logging.getLogger().setLevel(logging.INFO)
    with open(file_path, "r") as file:
        file_text = file.read()
        tree = javalang.parse.parse(file_text)
        methods = list()
        for _, node in tree.filter(javalang.parser.tree.MethodDeclaration):
            start, end = __get_start_end_for_node(node, tree)
            methods.append(__get_string(start, end, file_text))
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
