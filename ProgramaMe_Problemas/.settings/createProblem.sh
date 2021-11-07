#!/bin/sh

# Function to get the number of the problem
getNumber() {
    read -p "Enter the number of the problem: " problemId;
    if [ -z "$problemId" ]; then
        echo "Invalid number!"
        getNumber
    fi
}

# Function to get the name of the problem
getName() {
    read -p "Enter the name of the problem: " problemName;
    if [ -z "$problemName" ]; then
        echo "Invalid name!"
        getName
    fi
}

# Constants
settingsFile=".settings/settings.json";

# Get baseDir and currentDir values form settings.json
baseDir=$(jq -r '.baseDir' $settingsFile);
currentDir=$(jq -r '.currentDir' $settingsFile);
fullDirectory=$baseDir$currentDir;

# get the number and the name of the problem
getNumber;
getName;

# Ask if the user wants to cancel
echo "You are about to create the problem:\n - ID: $problemId\n - Name: $problemName\n";

read -p "Do you want to continue? (*/no) " answer;
if [ "$answer" = "n" ] || [ "$answer" = "no" ]; then
    echo "Exiting..."
    exit 0;
fi

# Create the problem directory
echo "Yay! $problemName $problemId $baseDir$currentDir" 