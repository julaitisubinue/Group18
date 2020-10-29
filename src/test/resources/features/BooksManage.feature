
Feature:  As an authorized user, I should able to access Books  page and and manage books information
  @select_one_category @AC1
  Scenario: Select one of book category
    #Given user is on the login page
    #And user logs in as librarian
    Given I am at the Books Management page
    #Then user select one of the  "Book" Category
    Then user select "Classic" from Book Category
    #And The table should display only one record with selected category
    And The table should display only "Classic" books

  @AC5
  Scenario: User should be change number of displayed records on the page
    Given I am at the Books Management page
     When user select  page number
     Then should display only selected number of pages