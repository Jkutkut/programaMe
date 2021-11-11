#!/usr/bin/sh

# * ***** COLORS *****
NC='\033[0m' # No Color
sBG='\e[1;7m';
rBG='\e[1;41m';
bBG='\e[1;44m';
gBG='\e[1;42m';
RED='\033[0;31m';
GREEN='\033[0;32m';
LRED='\033[1;31m';
LGREEN='\033[1;32m';
YELLOW='\033[1;33m';
LBLUE='\033[1;34m';
TITLE='\033[38;5;33m';

getArrow(){
    echo $(/usr/bin/env bash -c "escape_char=\$(printf '\u1b');
    read -rsn1 mode # get 1 character
    if [[ \$mode == \$escape_char ]]; then
        read -rsn2 mode; # read 2 more chars
    fi
    case \$mode in
        '[A') echo UP; exit 0;;
        '[B') echo DN ;;
        '') echo EN;;
        *) >&2 echo 'ERR bad input';;
    esac");
}

# Gets the screen ready to use the terminal.
# Clears screen, get new height based on the title, titleGap and print title with the fixed position.
# Arguments:
# type ($1) - It can be "list" when a list is going to be selected or "textmode" when the cursor is needed.
init(){
    # variables
    titleH=4;
    titleSpace=2;
    consoleLines=$(tput lines);

    height=$(($(tput lines)-1-$titleH-$titleSpace-1));
    
    # get the max(height, dataL)
    menuH=$(($height>$dataL ? $dataL : $height));

    # Clear the terminal
    clearTerminal;

    setCursorLocation "start"; # Set cursor on the top of the screen

    # Show title
    # printf "$title";

    setterm -cursor off; # cursor_blink_off
    stty -echo; # hide text typed
}

clearTerminal() {
    # Clear the terminal from the line $start
    start=0;
    if [ ! -z $1 ]; then # If start is defined, update it
        start=$1;
    fi

    emptyLine="";
    c=0;
    while [ $c -lt $(tput cols) ]; do
        emptyLine=" $emptyLine";
        c=$(( $c + 1 ));
    done

    tput cup $start; # Set cursor on the start line
    for i in `seq $start $(tput lines)`; do
        setCursorLocation $i;
        printf "$emptyLine";
    done
}

updateScreen(){
    updateType=$1;
    
    # If updating all screen
    if [ "full" = $updateType ]; then
        clearTerminal $(($titleH+$titleSpace));
        for idx in $(seq 0 $dataL); do
            text=$(getLine "$data" $idx 0);

            tput cup $(($titleH+$titleSpace+$idx));

            if [ $idx -eq $selected ]; then
                formatLine "$text" "$sBG";
            else
                formatLine "$text";
            fi

            idx=$(($idx + 1));
        done
    # else # If updateType == normal
    fi
}

# Formats the given line with (optional) format.
# Inputs:
#   $1: line to print
#   $2: (optional) format of the content
formatLine() {
    l=$1; # Get the line
    bg=$2;

    printf "  - $bg$l${NC}";
}

# Gets the nth line(s) of the given multiline argument
# Inputs:
#   $1: Data to get the information (normally the result of using "cat $FILENAME").
#   $2: Start line (0 based).
#   $3: Amount of extra lines desired (0 to get a single line, 1 to get 1+1 lines...).
# Returns:
#   The content required on a single line without any format.
getLine(){
    startLine=$(($2 + 1));
    amount=$3;
    endLine=$(($startLine+$amount));

    echo "$(echo $data | cut -d " " -f $startLine-$endLine)";
}

endCode(){
    # rm -f temp.txt; # Remove temporal file
    setterm -cursor on; # cursor_blink_on
    stty echo; # Show input text again

    if [ ! "$1" = "noOutput" ]; then # if no "no output" given, give output
        echo "\n${RED}~~~~~~~~  ERROR ~~~~~~~~\n$1${NC}";
    fi
    exit 1;
}

# Set the cursor on the given location in the terminal:
# Inputs:
#   $1: The desired row. Possible inputs:
#       - "start": The first line of the terminal
#       - "menu": Location in the menu.
#                 This option takes an additional argument ($2) with the index desired. This makes the $2 argument the $3.
#       - "end": End of the console.
#       - any: The desired number of the row.
#   $2: (optional) the desired column. If not given, the default value is 0.
setCursorLocation() {
    # Get columns
    col=0;
    if [ ! -z $2 ]; then # If columns given
        col=$2;
    fi

    # Get the row based on the value given
    case $1 in
        start)
            row=1;
            ;;
        menu)
            row=$(( $titleH + $titleSpace + $2));
            
            if [ ! -z col ]; then # If 3º argument given, this is the desired column
                col=$3;
            fi
            ;;
        end)
            row=$(($(tput lines) - 1));
            ;;
        *) # Else, the value given should be the desired row
            row=$1;
            ;;
    esac

    tput cup $row $col;
}

# Show a list with the given data

# *** VARIABLES ***
echo "Data\n$1\n$2";
title=$(cat $1); # Get the title from the file
data=$(cat $2); # Get the data from the file
dataL=$(( $(cat $2 | wc -l) - 1)); # Get the amount of lines of the data


# *********** CODE ***********

init; # Init zone
trap 'init' WINCH # When window resized, update screen with the new size
trap "endCode fail \"code force-ended\"" 2; # If code forced to end, run endCode first
trap "endCode fail \"code failed to execute\"" 1; # If code failed to execute, run endCode before ending

start=0;
selected=0;
updateScreen "full";
while false; do
# while true; do
    oldHeight=$height;

    # user key control
    # case $(getArrow) in # Get and analize the arrow input
    #     EN) # If enter pressed, exit
    #         break
    #         ;;
    #     UP) # If up arrow pressed
    #         selected=$(($selected-1)); # Selector go up
    #         ;;
    #     DN) # If down arrow pressed
    #         selected=$(($selected+1));
    #         ;;
    # esac

    # If selector out of screen (top)
    # if [ $selected -eq -1 ]; then
    #     selected=0; # Selector now on top
    #     start=$(($start-1)); # Move all repos down
    #     if [ $start -eq -1 ]; then # If out of index
    #         start=$(($dataL - 1)); # Set index to the last one
    #     fi
    # # else, if bottom is reached (bottom)
    # elif [ $selected -ge $(($height + 1)) ]; then
    #     selected=$height;
    #     start=$(($start+1)); # Move all repos up
    #     if [ $start -ge $(($dataL + 1)) ]; then
    #         start=0;
    #     fi
    # else # if correct position
    #     if [ $oldHeight -eq $height ]; then # If no change on the height of the screen
    #         updateScreen "normal";
    #         continue;
    #     else # else, update the "full" screen with the new height
    #         init "list"; # Clear screen, get new height based on the title, titleGap and print it with the fixed position
    #     fi
    # fi
    # updateScreen "full";
done


# * END CODE LOGIC *
setCursorLocation "end"; # Set cursor on the last row.
setterm -cursor on; # cursor_blink_on
stty echo; # Show input text again
exit 0;