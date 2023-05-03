@search @google @regression @smoke
Feature: Google search

  @whatever
  Scenario: Verifying the results for google search
    Given I am on the google page
    When I search for "Toyota"
    Then I should see only "Toyota" related results

    @test
    Scenario: Verifying image result
      Given I am on the google page
      When I search for "James Bond"
      And I click on image option
      Then I should see only "James Bond" related images


