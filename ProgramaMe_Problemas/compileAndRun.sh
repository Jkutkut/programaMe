#!/bin/sh
DIRBASE="src/dam/jorgeRe/y2021/navidad/p580_FotoMafalda/";
EXER="FotoMafalda.c";
DATA="data.txt";
EXPECTED="expected.txt";

OUTPUT="bin/executable";



gcc $DIRBASE$EXER -o $OUTPUT;

echo "===========";
./$OUTPUT < $DIRBASE$DATA;
echo "===========";

echo "\nExpected:\n===========\n$(cat $DIRBASE$EXPECTED)\n==========="