#!/bin/sh

for jarfile in libs/*.jar; do
  export CLASSPATH=`pwd`/$jarfile:$CLASSPATH
done