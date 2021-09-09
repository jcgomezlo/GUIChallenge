Feature: Login

  Scenario: Successful Login
    Given the user wants to login
    When the user enters the credentials
    Then the user should be able to login

  Scenario: Failed Login
    Given the user wants to login
    When the user submits invalid credentials
    Then the user should see a red error message
    And the user should see two more error messages