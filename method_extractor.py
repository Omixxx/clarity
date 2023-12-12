import argparse
import logging
import re

METHOD_PATTERN_REGEX = r"\b(?:public|private|protected|static|final|\s)+([\w<>]+)\s+(\w+)\s*\([^)]*\)\s*{([^}]*)}"


def main():
    logging.getLogger().setLevel(logging.INFO)
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
    with open(file_path, "r") as file:
        file_text = file.read()
        found_methods = re.finditer(METHOD_PATTERN_REGEX, file_text, re.DOTALL)
        methods_list = [match.group(0) for match in found_methods]
        for method in methods_list:
            print(method)


if __name__ == "__main__":
    main()
