
Feature: Test login functions
  Scenario: 1. The home page is loaded
    Given the Site is opened
    Then the Login-logo is visible
    And the Username input field is visible
    And the Password input field is visible
    And the Login button is visible
    And the Credentials Helper is visible

  Scenario Outline: 2. The login is successful with the correct credentials
    Given the Site is opened
    When the <username> username is typed into the Username input field
    And the <password> password is typed into the Password input field
    And the Login button is clicked
    Then the App logo is visible
    And the Products title is visible
    And the Products are visible

    Examples:
    | username      | password     |
    | standard_user | secret_sauce |
    | problem_user  | secret_sauce |

  Scenario: 3. The login is not successful with the incorrect credentials
    Given the Site is opened
    When the incorrect username is typed into the Username input field
    And the incorrect password is typed into the Password input field
    And the Login button is clicked
    Then the error message is displayed

  Scenario: 4. The clicking of the close button on the error message hides the error message and error icons
    Given the Site is opened
    And the incorrect username is typed into the Username input field
    And the incorrect password is typed into the Password input field
    And the Login button is clicked
    And the error message is displayed
    When the close button on the error message is clicked
    Then the error message is not displayed
    And the error icons are not displayed
