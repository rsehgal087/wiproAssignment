#!/bin/bash

read -p "enter the filename :" filename

if [ -e $filename ]
then
echo "file exists"
else
echo "file does not exist"
fi

echo "checking the read permission"
if [ -r $filename ]
then
echo "file has read permission"
else
echo "file does not have read permission"
fi
