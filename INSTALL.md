# Installation instructions

Before the plugin can be installed in the Jira instance, the source code needs to be modified to reference the appropriate field Id's to be used in the calculation. Afterwards the plugin will need to be recompiled.

To update the field references open the WSJFField.java file found in src->main->java->com->as->plugins->customfields->jira->customfields. At the top of the class you will see the following strings declared:
    private String storyPointsId = "customfield_10000";
    private String timeCriticalityId = "customfield_10001";
    private String riskOpportunityValueId = "customfield_10002";
    private String businessValuePreId = "customfield_10003";

Update the String values to be the ids in the Jira instance that represent the values of the the formula parts.

Once the ids have been updated, from within the directory run the "atlas-package" command from the Atlassian SDK. This will generate the JAR file with the correct ids.

In the Jira Administration section select the 'Add-ons' tab and then go to the 'Manage add-ons' sub section.

From here click the link for 'Upload add-on' then click 'Choose File' and select the JAR file that was generated in the previous steps.

Afterwards click 'Upload' and the plugin will be installed.
