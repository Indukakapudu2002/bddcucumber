Feature: Invalid Login Request

  Scenario: User attempts to login with invalid credentials
    Given user provides invalid credentials
    When the user makes a POST request to the login endpoint
    Then the user should receive an error message

