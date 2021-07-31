#Author: madhuri
@Logout
Feature: validate logout functionality

Scenario: Logout from the salesforce dashboard 
Given user is on salesforce dashboard page
And click on profile pic
When click on Logout button
Then Login page is displayed

