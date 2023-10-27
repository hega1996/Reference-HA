@login
Feature: Products page functions

  Background:
    Given the Site is opened
    And the "standard_user" username is typed into the Username input field
    And the "secret_sauce" password is typed into the Password input field
    And the Login button is clicked

  Scenario: 1. Verifying the default option in the dropdown menu
    Given the Products are visible
    When the sorting dropdown box is clicked
    Then the following options are in the dropdown list:
    | Name (A to Z)      |
    | Name (Z to A)      |
    | Price (low to high)|
    | Price (high to low)|

  Scenario Outline: 2. Verifying the menu visibility
    Given the Products title is visible
    When the menu button is clicked
    Then the "<items>" menu item is visible

    Examples:
    | items           |
    | All items       |
    | About           |
    | Logout          |
    | Reset App State |

  Scenario: 3. The Add to cart button of an item changes to remove when I add it to the shopping cart
    Given the Products are visible
    When the add to cart button is clicked
    Then the remove button is visible"

  Scenario: 4: An item is added to the shopping cart if I add it to the shopping cart
    Given the Products are visible
    When the add to cart button is clicked
    And the Shopping cart button is clicked
    Then an item is in the inventory
