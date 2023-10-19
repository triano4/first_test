Feature: Login into application

  @OnlyOneTime
 Scenario Outline: Login to application as valid user
    Given Login to application
    When user input <username> as username
    And user input <password> as password
    And user click submit
    Then Homepage should be displayed

  Examples:
  |username   | password |
  |standard_user  | secret_sauce|

  Scenario Outline: Login to application as invalid user
    Given Login to applications
    When user input invalid user <invalidusername> as invalidusername
    And user input invalid pass <invalidpassword> as invalidpassword
    And user click submits
    Then error should be displayed

    Examples:
      |invalidusername   | invalidpassword |
      |stanrd_user  | steadfast    |


#  Scenario: Login to application as invalid user
#    When User input invalid credentials
#    Then Error message should be displayed