#!/bin/sh

### Usage: . ./setup_env.sh ############################################
###### Be sure to source this script from the uploader dir #############
### This is the dir where the Uploader.java and libs/ are located ######

for jarfile in libs/*.jar; do
  export CLASSPATH=`pwd`/$jarfile:$CLASSPATH
done
