#!/bin/sh

clear
javac %1.java
chmod -x %1.class
java %1

