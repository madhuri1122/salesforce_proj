#Author: madhuri
@Login
Feature: Validate login functionality

Scenario: Lunch Salesforce site and Login
Given User is on Salesforce Login page
And Enter username
And Enter password
When click on login button
Then Home page displayed 

  