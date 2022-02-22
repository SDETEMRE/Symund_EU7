@SYMU-1057
Feature: Login with positive and negative scenarios


  @SYMU-1047
  Scenario Outline: login with valid credentials <username>

    Given the user logged in "<username>" and "<password>"
    Then Verify that user can login

    Examples:

      | username   | password    |
      | Employee11 | Employee123 |
      | Employee21 | Employee123 |
      | Employee31 | Employee123 |
      | Employee41 | Employee123 |

  @SYMU-1052
		#Verify that "Wrong username or password." should be displayed for invalid credentials
  Scenario Outline: login with invalid credentials <user>

    Given the user logged in "<username>" and "<password>"
    Then the user should see the wrng message "Wrong username or password."
		   # Given the user clears the username input box

    Examples:
      | username     | password    |
      | Employee4111 | Employee123 |
      | Employee41   | invalid     |
      | rroyee4111   | invalid     |

  @SYMU-1055
	    # Verify that "Please fill out this field" message should be displayed if the password or username is empty
  Scenario: login with invalid credentials

    Given the user logged in with username "" and password "Employee123"
    Then the user should see the fillOut messageUser "Please fill out this field."
    And the user clears the password input box
    Given the user logged in with username "Employee41" and password ""
    Then the user should see the fillOut messagePassword "Please fill out this field."


  @SYMU-1060
  Scenario: User can see the password in a form of dots by default

    Given the user enters username and password
    Then the user see the password in a form of dots by default

  @SYMU-1061
  Scenario: User can see the password explicitly if needed

    Given the user enters username and password
    And the user clicks on eye button
    Then the user see password explicitly

  @SYMU-1062
  Scenario: user can see the "Forgot password?" link and can see the "Reset Password" button
  after clicking forgot password button

    Given the user can see Forgot password link
    And the user can click forgot password button
    Then the user can see reset password button

  @SYMU-1063
  Scenario: Verify that user can see valid placeholders on Username and Password fields

    Given the user can see valid Username field
    Then the user can see valid Password field

  @SYMU-1068
    Scenario: Verify that user can not login with invalid username
      Given the user logged in with username "employee41" and password "Employee123"
      Then the user can not go to home page