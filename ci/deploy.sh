#!/bin/bash

export env=$1
export version=$2
JAR_NAME=/home/travis/build/madhukotagiri/HelloWorldJava/target/HelloWorldJava-${version}.jar
CLASS_NAME="Amma"

if [ ${env} = "dev" ] || [ ${env} = "staging" ] || [ ${env} = "prod" ]; then
    java -cp ${JAR_NAME} ${CLASS_NAME}
else
    echo "Invalid Environment"
	exit 1
fi