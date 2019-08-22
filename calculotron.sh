#!/usr/bin/env bash
clear
javac -classpath out:lib/* -d out Main.java 2> log/error.txt
if [[ $(< log/error.txt) != "" ]]; then
    cat log/error.txt
else
    java -classpath out:lib/* --module-path lib --add-modules javafx.controls,javafx.fxml Main &
fi