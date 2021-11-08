#!/bin/sh

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

init(){
    # variables
    titleH=4;
    titleSpace=2;
    height=$(($(tput lines)-1-$titleH-$titleSpace-1));

    echo "$title";

    # code
    for i in `seq 0 $(tput lines)`; do printf "\n"; done # Clear the terminal
    tput cup 0; # Set cursor on the top of the screen

    printf $title;

    if [ ! $2 = "textmode" ]; then # If no textmode => option mode
      setterm -cursor off; # cursor_blink_off
      stty -echo; # hide text typed
    else
      setterm -cursor on; # cursor_blink_off
      stty echo; # hide text typed
    fi

}

updateScreen(){
    idx=0;
    if [ "full" = $1 ]; then
        for i in $(seq 0 $height); do
            tput cup $(($titleH+$idx+$titleSpace));
            index=$(( ($start+$i) % $repoL + 1));#Get the lenght of the element
            text=$(getLine temp.txt $index 1);

            if [ $i -eq $selected ]; then
                setMessage $text 3 $sBG;
            else
                setMessage $text 3;
            fi
            idx=$(($idx+1));
        done
    else
        
        for i in $(seq -1 1); do
            line=$(($titleH+$titleSpace+$selected+$i));
            if [ $(($selected+$i)) -gt $height ] || [ $(($selected+$i)) -eq -1 ]; then 
                continue;
            fi
            tput cup $line;
            index=$(( ($start+$selected+$i) % $repoL + 1));#Get the lenght of the element
            text=$(getLine temp.txt $index 1);
            
            if [ $i -eq 0 ]; then
                setMessage $text 3 $sBG;
            else
                setMessage $text 3;
            fi
            idx=$(($idx+1));
        done
    fi
}

setMessage(){
    if [ $# -eq 1 ]; then # If no offset given, supose 0
        offs=0;
    else # If given, use it
        offs=$2;
    fi
    l=$(tput cols); # cols of the terminal
    gap=$(($l-${#1}-$offs)); # characters I can fit between the end of the message and the end of the terminal
    
    printf %${offs}s; # Print offset
    printf $3$1${NC}; # print message with the color given
    printf %${gap}s; # print the end of the line with blank characters
}

getLine(){
    start=$2;
    get=$3;
    echo $(tail -n +$start $1 | head -n $get);
}

endCode(){
    # rm -f temp.txt; # Remove temporal file
    setterm -cursor on; # cursor_blink_on
    stty echo; # Show input text again

    if [ ! "$2" = "noOutput" ]; then # if no "no output" given, give output
      if [ $1 = "fail" ]; then
          echo "\n${RED}~~~~~~~~  ERROR ~~~~~~~~\n$2${NC}";
      fi
    fi
    exit 1;
}


# Show a list with the given data

# *** VARIABLES ***
title=$2;
lines=$1; # Get the data from the argument
linesL=$(echo $lines | wc -w); # Get the number of elements

# *********** CODE ***********

init "list" "optionmode"; # Init zone
# trap 'init' WINCH # When window resized, update screen with the new size
# trap "endCode fail \"code force-ended\"" 2; # If code forced to end, run endCode first



# start=0;
# selected=0;
# # updateScreen "full";
# while true; do
#     break;
#     oldHeight=$height;

#     # user key control
#     case $(getArrow) in # Get and analize the arrow input
#         EN) # If enter pressed, exit
#             break
#             ;;
#         UP) # If up arrow pressed
#             selected=$(($selected-1)); # Selector go up
#             ;;
#         DN) # If down arrow pressed
#             selected=$(($selected+1));
#             ;;
#     esac

#     if [ $selected -eq -1 ]; then # If selector out of screen
#         selected=0; # Selector now on top
#         start=$(($start-1)); # Move all repos down
#         if [ $start -eq -1 ]; then # If out of index
#             start=$(($repoL - 1)); # Set index to the last one
#         fi

#     elif [ $selected -ge $(($height+1)) ]; then
#         selected=$height;
#         start=$(($start+1)); # Move all repos up
#         if [ $start -ge $(($repoL+1)) ]; then
#             start=0;
#         fi
#     else
#         if [ $oldHeight -eq $height ]; then # If no change on the height of the screen
#             updateScreen "normal";
#             continue;
#         else # else, update the "full" screen with the new height
#             init "list"; # Clear screen, get new height based on the title, titleGap and print it with the fixed position
#         fi
#     fi
#     updateScreen "full";
# done

# # At this point, everything should be ready to clone:

# init "main" "textmode"; # Init zone
# tput cup $(($titleH+$titleSpace)); # Set cursor at initial position

endCode "" "noOutput";