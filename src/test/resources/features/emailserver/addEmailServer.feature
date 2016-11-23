Feature: Email Server.

  Scenario: Add a new email server with another already added
    Given I add an email server with the data
      | DOMAIN      | win-v5ujsn3jja5.autorm.local |
      | USER        | administrator                |
      | PASSWORD    | Control123                   |
      | DESCRIPTION | Hello baby                   |
    Given I add an email server by default
#    And I send a POST request to projects.json
