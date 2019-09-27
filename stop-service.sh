#!/bin/bash
if [  ! -n "$1" ];then
  echo 'call shell script error! for example: sh stop-server api '
  exit
fi


pid=`ps -ef|grep  mall-$1|grep -v 'grep' |awk  '{print $2}'`
echo '*******************  step1: stop service application pid ='$pid' *******************************'

if [ -n "$pid" ]; then
 kill -9 $pid
fi
