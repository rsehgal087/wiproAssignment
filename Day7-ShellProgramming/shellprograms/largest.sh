#!/bin/bash

read -p "enter the num1 :" num1
read -p "enter the num2 :" num2
read -p "enter the num3 :" num3

if(($num1>$num2 & $num1>$num3))
then
echo "$num1 is largest"
elif(($num2>$num1 & $num2>$num3))
then
echo "$num2 is largest"
else
echo "$num3 is largest"
fi
