#!/bin/bash

#initialize the array elements
fruits=("apple" "mango" "orange")

#printing array elements using index
echo "${fruits[0]}"
echo "${fruits[1]}"

#array length
echo "${fruits[@]}"
echo "${#fruits[@]}"

for fruit in "${fruits[@]}"
 do
  echo "elements are $fruit"
 done
