@MobileTest @SmokeTest
Feature: Privacy & Legal

  In order to review the privacy and legal disclaimers
  As a regular DisneyLand app user
  The user should be able to see the different legal options

  Scenario: Find privacy and Legal options

    Given An user navigated to the more options tab
    When The user swipes down to the bottom
    And tap on the Privacy & Legal button
    Then they should see all the privacy and legal options displayed
