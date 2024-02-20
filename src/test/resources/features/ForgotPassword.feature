Feature: Forgot password

  Background:
    Given User is on OrangeHRM login page and clicks on forgot your password

  @ResetPassword @ClickResetPassword
  Scenario: User is able to reset password
    When User is taken to reset password page
    Then User is able to enter username as "Admin" and click on reset password
    And User is taken to reset password link sent page

  @ResetPassword @CancelResetPassword
  Scenario: User clicks on cancel button in reset password page
    When User is taken to reset password page and clicks cancel
    Then User is taken back to login page


