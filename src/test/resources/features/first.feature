Feature: Login Page
  As a user of the site
  I should be able to login

  Scenario: Login Page Title
    Given I go on "/swagger-ui.html"
    Then the title should equal "Swagger UI"
