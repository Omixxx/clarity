import argparse
import logging
import os

from git import Repo


def main():
    logging.getLogger().setLevel(logging.INFO)
    parser = argparse.ArgumentParser(description="Download GitHub repositories")
    parser.add_argument(
        "repo_list",
        metavar="repositories.txt",
        type=str,
        nargs=1,
        help="Repositories file path",
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
    os.chdir("../")
    if not os.path.exists("repos"):
        os.mkdir("repos")
    os.chdir("repos")
    for url in repo_urls:
        repo_name = url.split("/")[-1].strip()
        if not os.path.exists(repo_name):
            logging.info(f"Cloning {repo_name}...")
            Repo.clone_from(url.strip(), "./" + repo_name)
            logging.info(f"Cloned {repo_name} successfully")
        else:
            logging.info(f"Repo {repo_name} already exists")
    logging.info("All done ✨🚀")


if __name__ == "__main__":
    main()
