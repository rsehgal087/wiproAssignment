#!/bin/bash

for(( i=0;i<=5;i++ ))
do
echo " hi i am number $i"
done

for(( i=1;i<=10;i++ ))
do
 if [ $(($i%2)) == 0 ]
 then
 echo "number is $i"
fi
done
