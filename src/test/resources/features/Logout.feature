@SYMU-981
Feature: Default

	Background:

		Given the user logged in with username "Employee41" and password "Employee123"
	#*1-User can log out and ends up in login page*
	#2-User can not go to home page again by clicking step back button after successfully logged out.
	@SYMU-979
	Scenario: The user can log out and ends up in log in page(Automation)
		Given the user clicks on avatar button
		And the user clicks on logout button
		Then the user logged out and returns the login page	
	#1-User can log out and ends up in login page
	#*2-User can not go to home page again by clicking step back button after successfully logged out.*
	@SYMU-980
	Scenario: The user can not go to home page again by clicking step back button after logged out.(Automation)
		Given the user clicks on avatar button
		Then the user clicks on logout button
		And the user clicks back button after logout
		Then the user can not go to home page