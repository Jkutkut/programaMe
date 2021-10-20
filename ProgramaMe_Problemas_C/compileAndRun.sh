#!/bin/sh
DIRBASE="src/dam/jorge/y2021/navidad/p579_tareasFelipe/";
EXER="tareaFelipe.c";
DATA="data.txt";
EXPECTED="expected.txt";

OUTPUT="bin/executable";



gcc $DIRBASE$EXER -o $OUTPUT;

echo "===========";
./$OUTPUT < $DIRBASE$DATA;
echo "===========";

echo "\nExpected:\n===========\n$(cat $DIRBASE$EXPECTED)\n==========="