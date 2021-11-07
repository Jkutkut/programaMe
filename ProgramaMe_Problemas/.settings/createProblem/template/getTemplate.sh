#!/bin/sh

# Constants
SETTINGS_FILE=".settings/settings.json";
TEMPLATES_DIR=".settings/createProblem/template/";

# Get template type
templateType=$1;

# get username from json file settings
username=$(jq -r '.author' $SETTINGS_FILE);

# Switch template type: java or c
case $templateType in
    .java)
        templateFile=$TEMPLATES_DIR"java_templates.json";
        ;;
    .c)
        templateFile=$TEMPLATES_DIR"c_templates.json";
        ;;
    *)
        echo "Invalid template type";
        exit 1;
        ;;
esac

# Get all ids from json array separated by comma
templateIds=$(jq -r '.templates[] | .id' $templateFile);

