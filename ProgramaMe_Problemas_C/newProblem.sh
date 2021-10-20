#!/bin/sh
BASELOCATION="src/dam/jorge/y2021/navidad/";
TEMPLATE="src/plantilla/plantilla.c";

# Colors:
NC='\033[0m' # No Color
LBLUE='\033[1;34m';
TITLE='\033[38;5;33m';

ask(){ # to do the read in terminal, save the response in askResponse
  text=$1;
  textEnd=$2;
  read -p "$(echo ${LBLUE}"$text"${NC} $textEnd)->" askResponse;
}

ask "Number of problem? ";
problemNumber=$askResponse;

ask "Name of problem";
problemName=$askResponse;

mkdir $BASELOCATION"p$problemNumber"_$problemName;
cat $TEMPLATE >> $BASELOCATION"p$problemNumber"_$problemName/$problemName.c;
touch $BASELOCATION"p$problemNumber"_$problemName/data.txt;
touch $BASELOCATION"p$problemNumber"_$problemName/expected.txt;