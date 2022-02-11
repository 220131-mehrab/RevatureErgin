#!/bin/bash

DESTINATION=/c/users/ergin/bin/counttypes


install()
	{
	echo "installing to $DESTINATION..."
	cp counttypes $DESTINATION
	}	
uninstall(){
	echo "uninstalling from $DESTINATION..."
	rm $DESTINATION
}

test(){
	echo "Testing...."
	./counttypes num Dragon > testDragon.actual
	cmp testDragon.actual testDragon.expected || echo " Test failed "
}

buildClass(){
	echo "Creating the Counttypes Class in bin folder"
	javac -d bin src/Counttypes.java
}

run(){
	echo "building and compiling..."
	buildClass && java -cp bin Counttypes "$@"
        
}

"$@"
