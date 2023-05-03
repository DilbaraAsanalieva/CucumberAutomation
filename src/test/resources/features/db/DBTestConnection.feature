Feature: test connection to Codewise Database
  @dbConnection
  Scenario: happy path
    Given user connects to the database
    When user runs "select * from employees" query
    Then verify if data is returned

@wrongPassword
    Scenario: incorrect password
      Given user tries to connect to the database with incorrect password
      Then verify user is not able to connect
