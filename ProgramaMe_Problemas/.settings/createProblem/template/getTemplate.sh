#!/bin/sh

# Constants
SETTINGS_FILE=".settings/settings.json";

# Get template type
templateType=$1;

# get username from json file settings
username=$(jq -r '.author' $SETTINGS_FILE);

# Switch template type: java or c
case $templateType in
    .java)
        
        ;;
    .c)
        
        ;;
    *)
        echo "Invalid template type";
        exit 1;
        ;;