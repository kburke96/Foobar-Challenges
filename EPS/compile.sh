#/bin/bash

CURRENT_DIR=$(dirname $0)
CLASSES_DIR=$CURRENT_DIR/classes
HAMCREST_LIB=$CURRENT_DIR/hamcrest-core-1.3.jar
JUNIT_LIB=$CURRENT_DIR/junit-4.12.jar
MANIFEST_FILE=$CURRENT_DIR/manifest.txt
ERRORS_FILE=$CURRENT_DIR/errors
TEMP_FILE=$CURRENT_DIR/temp
OUTPUT_FILE=$CURRENT_DIR/tests.jar
IMPL_TO_COMPILE=$1
JAVA_FILES=`find $CURRENT_DIR -name "*.java"`


function compileJava {
mkdir $CLASSES_DIR
javac -cp $HAMCREST_LIB:$JUNIT_LIB -d $CLASSES_DIR $JAVA_FILES 2> $ERRORS_FILE
}

function removeClasses {
find $CURRENT_DIR/ -name "Node*Impl.class" ! -name "Node"$IMPL_TO_COMPILE"Impl.class" |xargs rm
}

function createJar {
jar cfm $OUTPUT_FILE $MANIFEST_FILE -C $CLASSES_DIR . 2>> $ERRORS_FILE
}

function cleanProject {
rm -rf $ERRORS_FILE $OUTPUT_FILE $CLASSES_DIR
}

function hideWorkDir {
cat $ERRORS_FILE | sed "s|$CURRENT_DIR||g" > $TEMP_FILE
cat $TEMP_FILE > $ERRORS_FILE
rm $TEMP_FILE
}


cleanProject
compileJava
removeClasses
createJar
hideWorkDir
