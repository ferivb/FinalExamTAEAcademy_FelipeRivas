@MobileTest @SmokeTest
Feature: Add Plans

  In order to reserve a diner
  As a regular DisneyLand app user
  The user should be able use the add plans feature

  Scenario: Check dining availability

    Given An user is in the Dashboard
    When The user taps on the plans button
    Then they should see the Check Dining Availability option