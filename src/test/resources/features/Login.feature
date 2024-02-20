Feature: Log in

  Background:
    Given User is on OrangeHRM login page

  @ValidLogin
  Scenario: Log in with valid credentials
    When User enters username as "Admin" and password as "admin123" and clicks on login
    Then User is logged in and navigated to landing page

  @InvalidLogin
  Scenario Outline: Log in with invalid credentials
    When User enters username as "<username>" and password as "<password>" and clicks on login
    Then User should be able to see "<errorMessage>"

    Examples:
      | username | password  | errorMessage        |
      | Admin    | admin12$$ | Invalid credentials |
      | admin$$  | admin123  | Invalid credentials |
      | abc123   | xyz$$     | Invalid credentials |