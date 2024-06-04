Feature: Invalid Login Scenario
  Scenario: Invalid Login Request
    Given user provides invalid credentials
    When the user makes a POST request to the login endpoint
    Then the user should receive an error message

