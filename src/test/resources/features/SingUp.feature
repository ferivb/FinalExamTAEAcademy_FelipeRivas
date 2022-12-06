
  Feature: Sing Up

    In order to securely use my ESPN account
    As a regular internet user
    I want to sing up and sing out successfully

  Scenario: Sing up successful

    Given An user just Singed up to the ESPN website
    And navigated to the Watch page
    When The user goes back to the Home Page and hover over the user Icon
    Then they should see their name next to the Welcome text
    And After they log out they should no longer see their name there
