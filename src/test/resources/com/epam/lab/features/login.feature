Feature: Login to Gmail
  This test will verify login related scenarios to mail.google.com

  Scenario Outline: Login with valid data
    Given User navigate to Gmail website
    When User enter Username as <username>
    And User click submit button
    And User enter Password as <password>
    And User click submit password button
    Then User should be on inbox page

    Examples:
      | username                 | password   |
      | oleh.sikorskyi@gmail.com | g3t7UZ?Rq- |