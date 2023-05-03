Feature: MVN Repository  Search

  Scenario: Verifying the search result for mvn repository
    Given  User is on  mvnrepository application
    And user search for "cucumber" on mvn application
    Then User should see only "cucumber" related results

