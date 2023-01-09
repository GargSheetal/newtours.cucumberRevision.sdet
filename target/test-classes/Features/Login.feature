Feature: Login

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given User launch chrome browser
    When User opens url "https://demo.guru99.com/test/newtours/"
    Then User enters User Name as "KusMeh" and Password as "KusMeh"
    And Clicks on submit button
    Then Page title should be "Login: Mercury Tours"
    When User clicks on SIGN-OFF link
    Then Page title should be "Welcome: Mercury Tours"
    And Close browser

  @regression
  Scenario Outline: Login Data Driven
    Given User launch chrome browser
    When User opens url "https://demo.guru99.com/test/newtours/"
    Then User enters User Name as "<username>" and Password as "<password>"
    And Clicks on submit button
    Then Page title should be "Login: Mercury Tours"
    When User clicks on SIGN-OFF link
    Then Page title should be "Welcome: Mercury Tours"
    And Close browser

    Examples: 
      | username | password |
      | KusMeh   | KusMeh   |
      | RicVer   | RicVer   |
      | DeeSha   | DeeSha   |
      | MohShe   | MohShe   |

  @regression
  Scenario: Fight Reservation
    Given User launch chrome browser
    When User opens url "https://demo.guru99.com/test/newtours/"
    Then User enters User Name as "KusMeh" and Password as "KusMeh"
    And Clicks on submit button
    Then Page title should be "Login: Mercury Tours"
    When User clicks on Flights link
    And Enters Flight details and Preferences
    And Clicks Continue button
    Then User can view message "After flight finder - No Seats Avaialble  "
    And Close browser
