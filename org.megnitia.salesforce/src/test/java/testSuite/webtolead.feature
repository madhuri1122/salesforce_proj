#Author: madhuri

@WebtoLead
Feature: navigate webtolead url,fill the form and submit

Scenario Outline: navigate url,fill and submit the form
Given user is navigate to url
And webtolead form should be displayed
When enter salutation as "<salutation>" firstName as "<firstName>" lastName as "<lastName>" email as "<email>" company as "<company>" city as "<city>" satae as "<state>" details to fill
And click on submit
Then it will automatically navigate to salseforce 

Examples:
| salutation | firstName | lastName | email              | company | city | state    |
| Mrs.       | madhu     | m        | maduri509@gmail.com| TCS     | Hyd  | Telangana|
