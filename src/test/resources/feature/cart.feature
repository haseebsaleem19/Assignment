Feature: Add and Remove Products from Cart

  Scenario: Add and remove products from the cart
    Given I am logged in to the Saucedemo website
    When I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bolt T-Shirt" to the cart
    And I remove "Sauce Labs Backpack" from the cart
    Then the cart should contain "Sauce Labs Bolt T-Shirt"
    And the cart should not contain "Sauce Labs Backpack"
    And I log out