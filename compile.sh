# compile source file to classes
echo "compiling source file begins...";
javac -cp ./src/ -d ./bin/ ./src/Main.java;
echo "compile finished...";

# copy manifest to bin
echo "coping manifest...";
cp -r ./src/META-INF ./bin/;

# exit if cd fails
cd ./bin || exit;

# package classes to jar
echo "packaging classes files to jar...";
jar cmvf ./META-INF/MANIFEST.MF MiniCAD.jar . > /dev/null;

# remove intermediate compilation files
echo "cleaning intermediate files...";
find . ! -name "MiniCAD.jar" ! -name "." ! -name ".." -type f,d -exec rm -rf {} +;
echo "project files packaged to ./bin/MiniCAD.jar";