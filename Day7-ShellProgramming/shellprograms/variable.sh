#!/bin/sh

name="rohit"
age=24

echo "name is  $name and age is $age"
echo "name is $name \n age is $age"
unset age
echo "name is $name  and age is $age"

country="india"
echo "$country"
readonly country
country="china"
