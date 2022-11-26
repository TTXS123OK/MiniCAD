# MiniCAD

* This is the first program of my 2022-fall java course.
* Requirement:
  * Use Java's awt and swing to make a simple drawing tool, operate in CAD mode, can place straight lines, rectangles, circles and text, can select graphics, modify parameters, such as colors, etc., can drag graphics and resize, and can save and restore.

    

### Runtime Environment
* Ubuntu 22.04 of WSL2
* OpenJDK 17

##### Installation
```shell
sudo apt update
apt-cache search openjdk
sudo apt-get install openjdk-17-jre
sudo apt-get install openjdk-17-jdk
java --version
```

##### Compile and Run
```shell
# compile
javac -cp ./src/ -d ./classes/ ./src/Main.java

# package to jar
jar cmvf META-INF/MANIFEST.MF MiniCAD.jar ./classes/*

# run
java -jar MiniCAD.jar
```