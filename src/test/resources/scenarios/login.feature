Feature: Login
  As a common user
  I want to log in to the website
  So that the system can remember my data

  Background: I am on the main page of the site
    Given I open Login page "https://the-internet.herokuapp.com/login"

  Scenario Outline: Successful login to the website
    When I enter my <userName> on the Login page
    And I enter my valid <userPassword> to the Login page
    And I click on Login button on the Login page
    Then I should successfully logged to the Login page
    Examples:
      | userName   | userPassword           |
      | 'tomsmith' | 'SuperSecretPassword!' |

  Scenario: Unsuccessful login to the website
    When I enter my 'tomsmith' username and invalid 'SuperSecretPassword' password on the Login page
    And I click on Login button on the Login page
    Then I shouldn't successfully logged to the Login page

