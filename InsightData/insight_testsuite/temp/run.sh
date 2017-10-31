#!/bin/bash

GRADER_ROOT=$(dirname ${BASH_SOURCE})
# src complete directory path
PROJECT_PATH=${GRADER_ROOT}//src
# dependency jar file
PROJECT_PATH1=${GRADER_ROOT}//src//junit.jar
# build all java files
javac -cp ${PROJECT_PATH1} ${PROJECT_PATH}//*.java
# entry point of program
java -cp ${PROJECT_PATH} TestDrive


