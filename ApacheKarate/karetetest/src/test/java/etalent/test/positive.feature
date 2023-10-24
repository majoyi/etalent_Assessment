Feature: POST Api


Background:
  * def baseUrl = 'http://localhost'
  * def port = 8080

Scenario: Testing • ID Number must be a valid South African ID number (13 digits)
Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 1122334455, "bankName": "SCRUM_BANK" },"idNumber": 9603225177080,"name": "Edwin","surname": "Ndlala"}
When method POST
Then status 200



Scenario:  Name and surname must not have any special characters and digits
  Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 1122334455, "bankName": "MINIONS_BANK" },"idNumber": 9603225177080,"name": "Edwin_","surname": "Ndlalar"}
When method POST
Then status 200
And match $ contains {errors:["Name must not have any special characters and digits"]}

Scenario: Testing a POST endpoint with request body
  Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 1122334455, "bankName": "MINIONS_BANK" },"idNumber": 9603225177080,"name": "Edwin","surname": "Ndlala"}
When method POST
Then status 200

Scenario: Invaid SA ID Number 
  Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 1122334455, "bankName": "ICONIC_BANK" },"idNumber": 960322517080,"name": "Edwin","surname": "Ndlala"}
When method POST
Then status 200
And match $ contains {errors:["ID Number must be a valid South African ID number (13 digits)"]}