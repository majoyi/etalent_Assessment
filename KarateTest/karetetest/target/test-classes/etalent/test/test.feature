Feature: POST Api

Background:
  * def baseUrl = 'http://localhost'
  * def port = 8080


Scenario: The client must be 18 years or older
  Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 1122334455, "bankName": "SCRUM_BANK" },"idNumber": 1007025304084,"name": "Edwin","surname": "Ndlala"}
When method POST
Then status 200
And match $ contains {errors:["The client must be 18 years or older"]}

Scenario: A valid bank must be captured
  Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 1122334455, "bankName": "MINIONS BANK" },"idNumber": 9603225177080,"name": "Edwin","surname": "Ndlala"}
When method POST
Then status 400

Scenario:If Molewa bank is captured, then the following warning must be returned “refer to compliance”
 Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 1122334455, "bankName": "MOLEWA_BANK" },"idNumber": 9603225177080,"name": "Edwin","surname": "Ndlala"}
When method POST
Then status 200
And match $ contains {warnings: ["Refer to compliance"]}

Scenario: The bank account number must be 10 digits
  Given url baseUrl + ':' + port + '/loans'
And request {"bankAccount": { "accountNumber": 11223344552, "bankName": "MINIONS_BANK" },"idNumber": 9603225177080,"name": "Edwin","surname": "Ndlala"}
When method POST
Then status 200