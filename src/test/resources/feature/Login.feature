Feature: Login to saucedemo.com

  Scenario: Successful login with valid credentials
    Given I am on the Saucedemo login page
    When I enter my username as "standard_user"
    And I enter my password as "secret_sauce"
    And I click the login button
    Then I should be logged in successfully
#
  Scenario: Unsuccessful login with invalid credentials
    Given I am on the Saucedemo login page
    When I enter my username as "invalid_user"
    And I enter my password as "invalid_password"
    And I click the login button
    Then I should see an error message