
Feature: Add User to the User List Table

  Scenario: Ensure that your users are added to the list.

    Given Navigate to the web tables page
    And Validate that you are on the User List Table
    And Click Add user
    And Add users to the User List Table
    Then Remove the users from the table

