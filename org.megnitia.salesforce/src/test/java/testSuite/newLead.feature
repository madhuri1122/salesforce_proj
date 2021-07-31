#Author: madhuri

@Leads
Feature: Create new lead,update lead and validate functionality

Scenario: Click the lead form
Given user is on salseforce dashboard page
When click lead object and click new lead
Then lead form should be displayed

Scenario Outline: create new lead by filling the form details
Given user is on load form page
When enter firstName as "<firstName>" middliName as "<middleName>" lastName as "<lastName>" salutation as "<salutation>" website as "<website>" sufix as "<sufix>" Company as "<Company>" Email as "<Email>" MobilePhone as "<MobilePhone>" industry as "<industry>" Leadsource as "<Leadsource>" details to fill
And click save
Then new lead should be created
Examples:
  | firstName | middleName | lastName | salutation | website   | sufix | Company | Email             | MobilePhone | industry | Leadsource |
  | madhuri    | baby       |manepalli | Mrs.       |madu.org.in| jr    | TCS     |maduri509@gmail.com| 9704262461  | Banking  | website    |   
 
 
Scenario: Go to Leads and selectselect requred lead
Given User is on Leads section
When Click on Recently viewed
And Click on Todays Leads in the list
And click on required lead
Then Requred Lead details will be opend

Scenario Outline: Edit lead data and check
Given User is on present saved Lead details page
And click on Edit
And change phoneNumber as per "<New_Mobile_Number>"
When click Save_button
Then mobile number upated

Examples:
| New_Mobile_Number |
|  9986892233         |

Scenario Outline: Move Lead to contact
Given user is on present saved Lead Details page
And clickChatter
And click on share
And send update about lead "<update1>"
And click on finalshare
And click on MarkStatus
And click on share
And send update about lead "<update2>"
And click on finalshare
And click on MarkStatus
And click on share
And send update about lead "<update3>"
And click on finalshare
And click on MarkStatus
Then Convert lead form will displayed
When click on Conver button
And click on Goto Leads button
Then Recently viewed lead page will appear

Examples:
  | update1    | update2               | update3         |
  | making call| convertion with client| client accepted |


 


 
