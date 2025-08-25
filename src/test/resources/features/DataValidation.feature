
Feature: Data Validation


  Scenario: Validate API created user is visible in UI
    Given I create a user via API
    When I search the user in UI table
    Then The user data should match with API data