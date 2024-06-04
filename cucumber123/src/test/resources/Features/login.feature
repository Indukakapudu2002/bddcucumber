Feature: Invalid Login Scenario
  Scenario: Invalid Login Request
    Given user provides invalid credentials
    When the user makes a POST request to the login endpoint "/api/admin/api-login"
    Then the response status code should be 401

