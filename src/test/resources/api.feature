Feature: Verify Library Api's'


Scenario: verify whether user is able to add new book

Given user has AddBook Api's'
When user calls AddBook Api with POST http request
Then book is added successfully with status code 200
And "Msg" in response is "successfully added"


@ft
Scenario: verify whether the user is created

Given user has CreateUser Api
When user calls Create Api with Post Http request
Then user should be created successfully



