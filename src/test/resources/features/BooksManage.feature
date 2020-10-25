
Feature:  As an authorized user, I should able to access Books  page and and manage books information
  @AC5
  Scenario: User should be change number of displayed records on the page
    Given I am at the Books Management page
     When user select  page number
     Then should display only selected number of pages