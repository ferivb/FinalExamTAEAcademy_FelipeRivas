@MobileTest @SmokeTest
Feature: Map Category List

  In order to book a Hotel
  As a regular DisneyLand visitor
  The user should see the hotels option when in the map screen

  Scenario: Hotels option found in the map's category list

    Given An user navigated to the map tab
    When The user taps on the category list
    Then they should see the book a hotel option enabled
