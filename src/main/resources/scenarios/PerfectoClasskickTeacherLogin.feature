
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
     Scenario: Create assignment with a blank assignment
          Given I validate login page is loaded
          When I clicks on login button on landing page
          And I enter the username "asd@mailnator.com" and password "test123" on login screen with remember me "false"
          #Then I validate user is logged in the assignment dashboard
          #When I delete all the assignments on the Assignments tab
          #And I click on plus icon in assignments page
          #And I select "New Blank Assignment" from the drop down menu
          #Then I validate user is taken to "Edit" Assignment view 
          #When I enter the name of new assignment as "Test Assignment"
          #And I navigate back to the Assignments page
          #Then I validate assignment details page is loaded for title "Test Assignment"

  