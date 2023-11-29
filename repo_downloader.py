import argparse
import logging
from git import Repo
import os


def main():
    parser = argparse.ArgumentParser(description="Download GitHub repositories")
    parser.add_argument(
        "repo_list",
        metavar="repo_list",
        type=str,
        nargs=1,
        help="Repo file path",
    )
    args = parser.parse_args()
    file_path = args.repo_list.pop()
    try:
        with open(file_path, "r") as file:
            list = file.read().split(",")
            logging.info("Cloning repos")
            clone_repos(list)
    except Exception as e:
        print(f"Error: {e}")
        exit(1)


def clone_repos(repo_urls: list[str]):
    for url in repo_urls:
        repo_name = url.split("/")[-1]
        if not os.path.exists(repo_name):
            logging.info("Cloning " + repo_name + " ...")
            Repo.clone_from(url.strip(), "./" + repo_name)
            logging.info("Cloned " + repo_name + " successfully")
        else:
            logging.info(f"Repo {repo_name} already exists")


if __name__ == "__main__":
    main()
