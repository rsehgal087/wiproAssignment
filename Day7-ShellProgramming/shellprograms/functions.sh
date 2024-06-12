#!/bin/bash

greet()
{
echo "hello all"
}

greet

#function with parameter
sum()
{
a=$1
b=$2
result1=$(($a+$b))
echo "result is $result1"

}
sum 4 5

read -p "enter value of a" arg1
read -p "enter value of b" arg2

sum $arg1 $arg2

sub()
{
a=$1
b=$2
subtract=$(($a-$b))
return $subtract
}

sub 10 5
res=$?
echo "result is $res"
