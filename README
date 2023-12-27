## 

## Configuration

#### 1. Setting up virtual enviroment

We recommend
[setting up](https://packaging.python.org/en/latest/guides/installing-using-pip-and-virtual-environments/)
a virtual enviroment

#### 2. Install requirements

```python3
pip3 install -r requirements.txt
```

## Usage

#### 1. Download repository

You can manually download java projects or you can use `repo_downloader.py` by
creating a file `.txt` containing the list of repo url

```txt
https://github.com/google/guice
https://github.com/google/guava
https://github.com/jenkinsci/jenkins
...
```

and launch it by using

```python3
python3 repo_downloader.py repo_list.txt
```

This will download all the repository into your local project

#### 2. Isolate all methods

In order to improve code readability you have to isolate methods from their
classes. <br> You can do that by using `rsm_input_generator.py` <br>

```python3
python3 rsm_input_generator.py guice/**/*.java
```

This will create a folder named as the project under `./temp` containing a file
for all method of all classes
