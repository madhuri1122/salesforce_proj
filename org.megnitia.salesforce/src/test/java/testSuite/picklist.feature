#Author: madhuri
@picklist
Feature: Collect the data from Object Manager



Scenario: Get pick list data using Object Manager
Given User is on salesforce dashboard page
And click on Setup symbol
And click on Setup button
And It should navigate to Setup Home page
When Click on Object Manager
And It will open New tab with Object Managet Title
And click on Module Which we want to Test
And It will disply Module details with with title of module Name
And Click on Fields and Relationships
And All items in Module will appear here
When Click on Requred item
And it will Opens with picklist values
And Read table of list of item values
And close the tab and move to salesforce dashboard page open new lead form
And Read list from Form
And compare both list after Sort