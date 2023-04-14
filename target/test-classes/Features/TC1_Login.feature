@login
Feature: Verifying OMR Branch Hotel Login Automation

  Scenario Outline: Verifying login with Valid credentials
    Given User is on the OMR Branch Hotel Page
    When User enters "<username>","<password>"
    Then User should verify Success message after login "Welcome Deepak"

    Examples: 
      | username                   | password     |
      | deepak1venkatesh@gmail.com | Password@123 |

  Scenario Outline: Verifying login with Valid credentials with Enter KEY
    Given User is on the OMR Branch Hotel Page
    When User enters "<username>","<password>" with enter key
    Then User should verify Success message after login "Welcome Deepak"

    Examples: 
      | username                   | password     |
      | deepak1venkatesh@gmail.com | Password@123 |


  Scenario Outline: Verifying login with Invalid credentials
    Given User is on the OMR Branch Hotel Page
    When User enters "<username>","<password>"
    Then User should verify error message after login "Invalid Login details or Your Password might have expired. "

    Examples: 
      | username                   | password |
      | deepak1venkatesh@gmail.com | Greens   |
