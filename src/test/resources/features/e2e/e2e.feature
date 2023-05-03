Feature:  Create a client on API and validate with CashWise UI

  @Nazima
  Scenario: Verify client is created successfully on API and data match with UI

    Given User hits and POST a client "endPoint"
      | company_name|Nazima|
      | client_name |Late  |
      | email       |example@gmail.com|
      | phone_number|7737717321       |
      | address     |Willis Tower,IL     |
      | tags_id     |Nzi              |

    When user navigates to CashWise APP guest page
    And User login to CashWise APP
    And Navigate to Clients Page
    Then Verify client details between UI and API


