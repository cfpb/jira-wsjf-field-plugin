# Jira WSJF Field Plugin

**Description**:  This plugin adds a custom field type to Jira that will autocalculate the Weighted Shortest Job First (WSJF) score for a ticket based on the four input fields specified. By autocalculating this we ensure that the WSJF score is up to date even if changes are made to any of the inputs.

Other things to include:

  - **Technology stack**: This plugin is written in Java and is intended for use with Jira Server software.
  - **Status**:  This project is stable and at a version 1.0.0 release. [CHANGELOG](CHANGELOG.md).


## Dependencies

To use this plugin you must have Jira Server.

To work on this plugin you must have Java installed, as well as the Atlassian Plugin SDK.

## Installation

Details for installation can be found in the [INSTALL](INSTALL.md) document.

## Configuration

This plugin needs to be configured to reference the correct fields in your Jira instance. Details for configuring this plugin are given in the [INSTALL](INSTALL.md) document.

## Usage

To use this feature in Jira server you must have 4 fields pre configured.
All four fields need to be either "Number Fields" or "Select List (single choice)" fields.
    In the case of the select list field all choices must be only numbers.
The four fields should represent the following inputs:
-Risk/Opportunity Value
-Time Criticality Value
-Business Value
-A measure of effort such as Story Points
The ids of the fields need to be mapped in the plugin code per the configuration instructions above.

After the plugin in installed per the Installation section the custom field can be added.

To add the field, navigate to "Issue" then "Custom fields" under the Jira administration menu.
Click "Add custom field", select the "Advanced" section on the left, and scroll to find the new field type.

The field will then be able to be managed on screens etc like all other fields.

If any of the four fields needed for the calculation are blank then the formula returns -1.00.
Otherwise the field with calculate and display the WSJF score.

## Known issues

The fields used to calculate the WSJF score cannot be changed without recompiling the plugin.

## Getting help

If you have questions, concerns, bug reports, etc, please file an issue in this repository's Issue Tracker.

## Getting involved

This project has a lot of room to grow. An upcoming feature to be implimented is being able to configure which fields are used in the calculation through the UI.

General instructions on _how_ to contribute should be stated with a link to [CONTRIBUTING](CONTRIBUTING.md).


----

## Open source licensing info
1. [TERMS](TERMS.md)
2. [LICENSE](LICENSE)
3. [CFPB Source Code Policy](https://github.com/cfpb/source-code-policy/)


----

## Credits and references

1. Projects that inspired you
2. Related projects
3. Books, papers, talks, or other sources that have meaningful impact or influence on this project
