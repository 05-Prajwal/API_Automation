Feature: Create New Users

  Scenario: Create a new user
    Given I Triggered the URL
    When I want the to create new users
      | firstName | lastName | subjectId | id  |
      | Iphone    | IOS      | 12        | 143 |
    Then Validate the response code 201

  Scenario: Create a new Subject
    Given I Triggered the URL
    When I want the to create new subjects
      | id | name |
      | 3  | API  |
    Then Validate the response code 201