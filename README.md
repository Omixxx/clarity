## Configuration 🪧

### Repository downloader (optional) ⤵️

#### 1. Setting up virtual enviroment

Under `/scripts` [set up](https://packaging.python.org/en/latest/guides/installing-using-pip-and-virtual-environments/) a virtual enviroment , i use `venv` then:

```python3
python3 -m venv .venv
```

Activate the virtual environment for the current
shell (the selection between the various `activate.something` will depend on your shell) <br>
I use [fish](https://fishshell.com/) so:

```python3
source .venv/bin/activate.fish
```

#### 2. Install requirements

```python3
python3 -m pip install -r requirements.txt
```

#### 3. Download repository

Now you can easily download java projects by using `repo_downloader.py` and passing to it
a `.txt` file containing the list of repo url you wish to get

```txt
https://github.com/google/guice
https://github.com/google/guava
https://github.com/jenkinsci/jenkins
...
```

you can launch it by using

```python3
python3 repo_downloader.py repo_list.txt
```

This will download all repositories to the project root under the `/repos` folder
### Project Analyzer setup 🗾 
Whether you have downloaded some projects using the script shown above, or whether you already have one or more projects to analyze, you can use docker to quickly configure the application

in the root of the project launch
```shell
docker build -t clarity .
```
If everything went correctly you can move on to the next section


## Usage 🪄
From the project root simply start the application by passing to it the ___absolute___ path of the projects you wish to analyze as volumes 
```shell
docker run -it -v $(realpath repos/guice/):/app/input/guice -v $(realpath repos/guava/):/app/input/guava clarity:latest
```
