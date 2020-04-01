Feature: SDET University User Login

  Background: 
    Given the user is on the login page

  Scenario: A user logs in with valid credentials
    When the user enters valid username and password
    Then the user is taken to the landing dashboard page

  #Scenario: A user attempts login with valid username and invalid password
#		When the user enters a valid username and an invalid password
#		Then the user is denied access to the website
#
  #Scenario: A user attempts login with invalid username and some password
#		When the user enters an invalid username and some password
#		Then the user is denied access to the website