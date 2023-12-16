import os
import method_extractor as me
import logging
import argparse
import platform


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

    if platform.system() == "Windows":
        prefix = "temp\\"
    else:
        prefix = "temp/"

    for file_path in args.files:
        logging.info("Processing file: %s", file_path)
        methods = me.extract_methods(file_path)
        temp_file_path = prefix + file_path.split(".")[0]
        file_type = file_path.split(".")[1]
        root_dir = os.getcwd()

        if not os.path.exists(temp_file_path):
            os.makedirs(temp_file_path)
        os.chdir(temp_file_path)

        for method in methods:
            with open(method[me.METHOD_NAME_KEY] + "." + file_type, "w") as f:
                f.write(method[me.METHOD_BODY_KEY])

        os.chdir(root_dir)


if __name__ == "__main__":
    main()
