@api
Feature: GET Clients API

  Scenario: Verifying the number of clients
    Given user hits get all clients API "/api/myaccount/clients" "false" "1" "5"
    Then user verifies that total number of clients should be "3"


