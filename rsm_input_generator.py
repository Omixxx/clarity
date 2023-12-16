import os
import method_extractor as me
import logging
import argparse

TEMP_FILES_PREFIX = "temp"


def main():
    logging.getLogger().setLevel(logging.INFO)
    parser = argparse.ArgumentParser(
        description="Process files based on a directory and optional extension."
    )
    parser.add_argument(
        help="Lista di file Java da compilare",
        type=str,
        nargs="+",
        action="store",
        dest="files",
    )
    args = parser.parse_args()

    for file_path in args.files:
        logging.info("Processing file: %s", file_path)
        methods = me.extract_methods(file_path)
        if not os.path.isdir(TEMP_FILES_PREFIX):
            os.mkdir(TEMP_FILES_PREFIX)

        os.chdir(TEMP_FILES_PREFIX)
        for method in methods:
            print(method)

        


if __name__ == "__main__":
    main()
