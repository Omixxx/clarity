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
https://github.com/google/guice,
https://github.com/google/guava,
https://github.com/jenkinsci/jenkins,
...
```

you can launch it by using

```python3
python3 repo_downloader.py repo_list.txt
```

This will download all repositories to the project root under the `/repos` folder

### Project Analyzer setup 🗾

Whether you have downloaded some projects using the script shown above, or whether you already have one or more projects to analyze, you can use docker to quickly configure the application <br>
before doing so, go to the clarity folder (where the pom.xml file is) and create a folder called `lib`

```bash
mkdir lib
```

then download at this [link](https://dibt.unimol.it/report/readability/files/readability.zip) the readability.zip file and extract it into the `lib` folder

```bash
unzip readability.zip -d path/to/lib
```

Now we can build the immage by running

```bash
docker build -t clarity .
```

## Usage 🪄

From the project root, where the dockerfile is located, simply run the following command:

```bash
docker run -it --name clarity -v $(realpath repos/):/app/input/ clarity:latest
```

where `repos` is the folder containing all the projects you want to analyze. <br><br>

When you launch the aforementioned command, your console will show you a series of logs, representing the fact
that the program is working. When you are shown the message `Work done!` then you can spawn a new shell
and copy the results from the container to a local folder, let's call it `output`, to view them better

```bash
docker cp clarity:app/temp ./output
```

### Fine tuning ⚙️

You can configure, through the `clarity/assets/env` file, various options to refine the effectiveness of the application.
<br> Specifically there are currently three variables: <br>

- `MAX_THREADS` &rarr; i.e. the maximum number of projects that the application will compute at the same time. It goes without saying that the more threads there are, the faster it will go, however it is advisable to have a high-performance machine for a high number of threads. The default value is 3 <br>

- `PERCENTAGE_OF_THE_MOST_READABLE` &rarr; This percentage tells the application how many of the most readable methods to keep (default is 20)

- `PERCENTAGE_OF_THE_WORST_READABLE` &rarr; This percentage tells the application how many of the less readable methods to keep (default is 20)

However, the application will also retain a median component, i.e. a quantity equal to the average between `PERCENTAGE_OF_THE_MOST_READABLE` and `PERCENTAGE_OF_THE_WORST_READABLE`.

The choice between the various files is explained through this illustration of the algorithm:

```
                                      delete    delete
                                        ^         ^
                                        |         |
                                       ---       ---
                                [a b c d e f g h i l m n o]
                                 -----     -----     -----
                                  |          |          |
                                  |          |          |
                                  v          v          v
                                worst       mid        best
```
