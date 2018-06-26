# ccms-barpawseb
ccms-barpawseb created by Bartek-Paweł-Sebastian

## Running your app

1. Save paths to all source files with your production code to a file:

    `find src -name "*.java" > production.txt`

2. Create output directory for compiled classes of your production code (thanks to `-p` parameter it will be created only if it does not exist without an error if it exists already):

    `mkdir -p out/production`

3. Compile all source files saved in `production.txt` file into specified directory:

    `javac @production.txt -d out/production`

4. To run `<name>` class you have run `java` command with the path to all compiled files and specified name of class including the name of the package it belongs to:

    `java -cp out/production/ <pack>.<pack>.<className>`
