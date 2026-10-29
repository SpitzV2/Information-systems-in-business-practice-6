@echo off
if exist out rmdir /s /q out
mkdir out
javac -encoding UTF-8 -d out src\ru\edu\pr03\*.java
java -cp out ru.edu.pr03.SelfCheck
