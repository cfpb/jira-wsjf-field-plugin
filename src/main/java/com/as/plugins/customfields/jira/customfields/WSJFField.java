package com.as.plugins.customfields.jira.customfields;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.customfields.SortableCustomField;
import com.atlassian.jira.issue.customfields.impl.CalculatedCFType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.config.FieldConfigItemType;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import java.util.List;
import java.util.Map;

@Scanned
public class WSJFField extends CalculatedCFType implements SortableCustomField{
    // Set the custom field ids to the strings below
    private String storyPointsId = "customfield_10008";
    private String timeCriticalityId = "customfield_14515";
    private String riskOpportunityValueId = "customfield_14512";
    private String businessValuePreId = "customfield_14503";

    @Override
    public Map<String, Object> getVelocityParameters(final Issue issue,
                                                     final CustomField field,
                                                     final FieldLayoutItem fieldLayoutItem) {
        final Map<String, Object> map = super.getVelocityParameters(issue, field, fieldLayoutItem);

        // This method is also called to get the default value, in
        // which case issue is null so we can't use it to add currencyLocale
        if (issue == null) {
            return map;
        }

         FieldConfig fieldConfig = field.getRelevantConfig(issue);
         //add what you need to the map here

        return map;
    }

    @Override
    public Object getValueFromIssue(com.atlassian.jira.issue.fields.CustomField field1,com.atlassian.jira.issue.Issue issue1) {
        //MutableIssue issueM = (MutableIssue)issue1;
        CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager();
        CustomField cf1 = customFieldManager.getCustomFieldObject(timeCriticalityId);
        CustomField cf2 = customFieldManager.getCustomFieldObject(riskOpportunityValueId);
        CustomField cf3 = customFieldManager.getCustomFieldObject(businessValuePreId);
        CustomField cf4 = customFieldManager.getCustomFieldObject(storyPointsId);
        Object o1 = issue1.getCustomFieldValue(cf1);
        Object o2 = issue1.getCustomFieldValue(cf2);
        Object o3 = issue1.getCustomFieldValue(cf3);
        Object o4 = issue1.getCustomFieldValue(cf4);

        if (o1 == null
            || o2 == null
            || o3 == null
            || o4 == null) {
            return -1.00;
        }

        Double value1 = Double.parseDouble(o1.toString());
        Double value2 = Double.parseDouble(o2.toString());
        Double value3 = Double.parseDouble(o3.toString());
        Double value4 = Double.parseDouble(o4.toString());

        Double wsjfScore = (value1+value2+value3)/value4;
        return (double) Math.round(wsjfScore * 100) / 100;
    }

    @Override
    public Object getSingularObjectFromString(java.lang.String string1) {
        return null;
    }

    @Override
    public String getStringFromSingularObject(java.lang.Object object1) {
        return null;
    }

    @Override
    public int compare(Object customFieldObjectValue1, Object customFieldObjectValue2, FieldConfig FieldConfig) {
        Double d1 = Double.parseDouble(customFieldObjectValue1.toString());
        Double d2 = Double.parseDouble(customFieldObjectValue2.toString());
        if (d1>d2) {
            return 1;
        }
        if (d1==d2) {
            return 0;
        }
        return -1;
    }
}