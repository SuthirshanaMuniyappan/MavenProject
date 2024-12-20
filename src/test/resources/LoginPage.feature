Feature: Login Page Functionality

  Scenario Outline: Successful Login with valid credentials
    Given The user is on the login page
    When User should login "<username>" and "<password>"
    And Clicks the login button
    Then The User should be redirected to the dashboard page
    And quit the 1st Browser

    Examples: 
      | username                               | password |
      | suthirshana.muniyappan@expleogroup.com | Suthir   |

  Scenario Outline: UnSuccessful Login with invalid credentials
    Given The user is on the login page
    When User enters a invalid "<username>" and "<password>"
    And Clicks the login button
    Then An error msg should be displayed
    And quit the 2nd Browser

    Examples: 
      | username                    | password |
      | suthirshana@expleogroup.com | Suthir   |

  Scenario Outline: Login with empty credentials
    Given The user is on the login page
    When The User leaves the "<username>" and "<password>" fields empty
    And Clicks the login button
    Then A valid msg should be displayed
    Then quit the 3rd Browser

    Examples: 
      | username | password |
      |          |          |
