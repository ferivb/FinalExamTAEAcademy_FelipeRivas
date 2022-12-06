
  Feature: Sing Up

    In order to securely use my ESPN account
    As a regular internet user
    I want to sing up and sing out successfully

  Scenario: Sing up successful

    Given I just Singed up to the ESPN website
    And navigated to the Watch page
    When I go back to the Home Page and hover over the user Icon
    Then I should see my name next to the Welcome text
    And After I log out I should no longer see my name there
