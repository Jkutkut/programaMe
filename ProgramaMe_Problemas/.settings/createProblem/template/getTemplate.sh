#!/usr/bin/sh

# Constants
NC='\033[0m' # No Color
LBLUE='\033[1;34m';
TITLE='\033[38;5;33m';

SETTINGS_FILE=".settings/settings.json";
TEMPLATES_DIR=".settings/createProblem/template/";

TITLE_FILE=".title.temp.txt";
IDS_FILE=".ids.temp.txt";
SELECTED_TEMPLATE_FILE=".selected.temp.txt";

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

echo "${TITLE} ____  ____  _  _  ____  __     __  ____  ____  ____
(_  _)(  __)( \\/ )(  _ \(  )   / _\(_  _)(  __)/ ___)
  )(   ) _) / \/ \ ) __// (_/\/    \ )(   ) _) \___ \\
 (__) (____)\_)(_/(__)  \____/\_/\_/(__) (____)(____/${NC}" >> $TITLE_FILE;

echo "$templateIds" >> $IDS_FILE;

echo "Creating selection menu";
./.settings/createProblem/menuSelection.sh $TITLE_FILE $IDS_FILE $SELECTED_TEMPLATE_FILE;

rm $TITLE_FILE $IDS_FILE;