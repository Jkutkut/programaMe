#!/bin/sh

# Colors:
NC='\033[0m' # No Color
LBLUE='\033[1;34m';
TITLE='\033[38;5;33m';

# Function to ask something to the user.
ask() {
  question=$1;
  textEnd=$2;
  read -p "$(echo ${LBLUE}"$question"${NC} $textEnd) -> " askResponse;

  if [ -z  "$askResponse" ]; then
    ask "$question" "$textEnd";
  else
    echo $askResponse;
  fi
}

# Function to get the number of the problem.
getNumber() {
    echo $(ask "What is the number of the problem?" " ");
}

# Function to get the name of the problem.
getName() {
    echo $(ask "Enter the name of the problem" "");
}

# Constants
settingsFile=".settings/settings.json";

# Get baseDir and currentDir values form settings.json
baseDir=$(jq -r '.baseDir' $settingsFile);
currentDir=$(jq -r '.currentDir' $settingsFile);
fullDirectory=$baseDir$currentDir;

# get the number and the name of the problem
problemId=$(getNumber);
problemName=$(getName);

problemDirectoryName=p$problemId"_"$problemName"/";

# Ask if the user wants to cancel
echo "You are about to create the problem:\n - ID: $problemId\n - Name: $problemName\n - Directory: $fullDirectory$problemDirectoryName\n";

read -p "Do you want to continue? (*/no) " answer;
if [ "$answer" = "n" ] || [ "$answer" = "no" ]; then
    echo "Exiting..."
    exit 0;
fi

# Create the problem directory
mkdir $fullDirectory$problemDirectoryName;

# ask if the user wants to use a template
read -p "Do you want to use a template? (c/java/no) " answer;
if [ "$answer" = "c" ] || [ "$answer" = "C" ]; then
    template=".c";
elif [ "$answer" = "java" ] || [ "$answer" = "Java" ]; then
    template=".java";
else
    # end the script
    echo "Exiting...";
    exit 0;
fi

mainName=$problemDirectoryName$template;

echo$(./.settings/createProblem/template/getTemplate.sh $template) > $fullDirectory$problemDirectoryName$mainName;