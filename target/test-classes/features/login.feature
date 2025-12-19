Feature: Login to SauceDemo

  As a user
  I want to log in to the application
  So that I can access the products

  Scenario Outline: Successful login
    Given that "User" is on the login page
    When he logs in with credentials "<username>" and "<password>"
    Then he should see the dashboard with title "<title>"

    Examples:
      | username      | password     | title    |
      | standard_user | secret_sauce | Products |
