
Feature:  As an authorized user, I should able to access Books  page and and manage books information
  @select_one_category @AC1
  Scenario: Select one of book category
    Given I am at the Books Management page
    Then user select "Classic" from Book Category
    And The table should display only "Classic" books

  @login @AC2
  Scenario: Login as a librarian
    #Given user is on the login page
    #When user logs in
    #Then user should see Library
    #When user click on the Book tab
    Given I am at the Books Management page
    And  user select view 5 records per page
    Then only 5 records are displayed on page

  @AC3
  Scenario: AC3: User should able to Add Book
    #Given I am at the Books page
    Given I am at the Books Management page
    When user click "Add Book" button
    Then The "Add Book" form is displayed

  @AC5
  Scenario: User should be change number of displayed records on the page
    Given I am at the Books Management page
     When user select  page number
     Then should display only selected number of pages

  @AC6
 Scenario: AC6: User should be able to Edit book
   Given I am at the Books Management page
    When user click "Edit Book" button
    Then The "Edit Book Information" form is displayed

    #  Scenario AC4: User should able to sort records on Books page
##  Given I am at the Books page
#  Given I am at the Books Management page
#  When I click "ISBM"
#  Then "ISBM" coulm should be sort it