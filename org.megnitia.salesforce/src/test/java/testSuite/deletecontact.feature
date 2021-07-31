#Author
@Delete
Feature: validate Delete functinality

Scenario: Check the Contact and Delete
Given User is on salesforce Dashboard page
And Click on Contacts
And Recently viewed contacts page will appear
And Cross check lead which is Converted As Contact
When click on Triangle  for options
And Options will display
And click on Delete Option
And It will ask again Delete Contact for conirmation
And click on Delete button
Then Contact Deleted status will appear

