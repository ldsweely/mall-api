#!/bin/bash

if [  ! -n "$1" ];then
  echo 'call shell script error! for example: sh stop-server api '
  exit
fi

sh  stop-service.sh $1

echo  '******************  step2: start service application ***********************************'

application='target/mall-'$1'.jar'

echo  $application
java  -jar  $application &
echo 'please read log file: '/opt/logs/$1/info.$1.log
tail  -f   /opt/logs/$1/info.$1.log
