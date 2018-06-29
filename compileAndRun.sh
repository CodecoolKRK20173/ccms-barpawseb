#!/bin/bash
find src -name '*.java' > sources.txt
mkdir -p out2
javac @sources.txt -d out2 && java -cp out: Main
