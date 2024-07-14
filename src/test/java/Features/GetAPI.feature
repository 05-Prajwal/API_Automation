Feature: Get all the Users list

  Scenario: Verify all the users
    Given I Triggered the URL
    When I want the list of users
    Then Validate the users list
      | name   | id |
      | Raghav | 1  |
      | Sarah  | 2  |

  Scenario: Verify all the Subjects
    Given I Triggered the URL
    When I want the list of subjects
    Then Validate the subjects list
      | Subject    | id |
      | Automation | 1  |
      | DevOps     | 2  |
