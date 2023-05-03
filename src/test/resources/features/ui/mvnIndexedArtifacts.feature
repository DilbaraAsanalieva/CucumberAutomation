Feature: MVN Repository Indexed Artifact

  Scenario: Verifying Top 20 repositories
    Given user is on mvnrepository application
    When user clicks on Index Artifacts menu
    Then user should see header "Top 20 repositories"
    And user should see "20" repositories in the result