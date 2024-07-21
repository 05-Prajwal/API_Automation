Feature: Create New Users

  Scenario: Create a new user
    Given I Triggered the URL
    When I want the to create new users
      | firstName | lastName | subjectId | id  |
      | Iphone    | IOS      | 12        | 143 |
    Then Validate the response code 201
    And Validate the response with JsonSchema of users


  Scenario Outline: Create a new Subject
    Given I Triggered the URL
    When I want the to create new subjects
      | id   | name   |
      | <id> | <name> |
    Then Validate the response code 201
    And Validate the response with JsonSchema of subjects
    Examples:
      | id | name |
      | 3  | data |
      | 4  | AI   |
