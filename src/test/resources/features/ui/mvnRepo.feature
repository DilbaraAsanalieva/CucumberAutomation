Feature: Popular tools MVN Repository

  @mvn @smoke
  Scenario: Verifying the top rated tools on mvn repository
    Given  User is on  mvnrepository application
    When User clickes popular link
    Then User should see tools from to rated to less rated



