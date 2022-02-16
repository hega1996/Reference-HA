
Feature: Test login functions

  Scenario: 1. The home page is loaded
    Given the Site is opened
    Then the Login-logo is visible
    And the Username input field is visible
    And the Password input field is visible
    And the Login button is visible
    And the Bot image is visible

  Scenario: 2. The login is successful with the correct credentials
    Given the Site is opened
    When the standard_user username is typed into the Username input field
    And the secret_sauce password is typed into the Password input field
    And the Login button is clicked
    Then the App logo is visible
    And the Products title is visible
    And the Products are visible