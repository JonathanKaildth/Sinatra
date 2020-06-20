Feature: Login
  Process by which a user gains access to our app
  Scenario:
    Given I'm a user navigating on Google.com
    When I click on the Sign-In button
    Then the page must the display the login screen