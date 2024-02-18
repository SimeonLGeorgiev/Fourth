@login
Feature: Test login functionality

  Scenario Outline: Check login with all user types in Saucedemo
    Given user is on login page
    Then <user> has logged in <condition>

    Examples:
      | user                    | condition      |
      | standard_user           | successfully   |
#      | locked_out_user         | unsuccessfully |
#      | problem_user            | successfully   |
#      | performance_glitch_user | successfully   |

