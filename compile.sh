# compile source file to classes
javac -cp ./src/ -d ./bin/ ./src/Main.java;

# copy manifest to bin
cp -r ./src/META-INF ./bin/;

# exit if cd fails
cd ./bin || exit;

# package classes to jar
jar cmvf ./META-INF/MANIFEST.MF MiniCAD.jar .;

# remove intermediate compilation files
find . ! -name "MiniCAD.jar" ! -name "." ! -name ".." -type f,d -exec rm -rf {} +;