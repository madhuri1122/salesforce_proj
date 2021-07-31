#Author:madhuri
@import
Feature: Import the Lead
Scenario: Import the lead by sending the CSV file
Given user is on Lead section
When click on Import it will navigete to Iport your Data into Salesforce page
And click on Leads on standard object
And click on Add new record
And click on CSV to uploas csv file
And CSV file selector box will open
And click on Choose file
And Send valid file path into text box
And click on Open button
And click on Next button
And click on Next button
And click on Startimport button
When click on ok
Then it will shows like Congratulations your import has started