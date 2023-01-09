Feature: Register

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given User launch chrome browser
    When User opens url "https://demo.guru99.com/test/newtours/"
    And Clicks on REGISTER link
    Then Page title should be "Register: Mercury Tours"
    Then Enters New User details
    And Clicks on submit button
    Then User can view configuration message "Thank you for registering"
    And Close browser
