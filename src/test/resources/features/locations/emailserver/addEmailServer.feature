Feature: Add a project to a workspace.

  Scenario: Login in Todo ly
    Given I add an email server with the data
      | DOMAIN      | win-v5ujsn3jja5.autorm.local |
      | USER        | administrator                |
      | PASSWORD    | Control123                   |
      | DESCRIPTION | Hello baby                   |
    Given I add an email server by default
#    And I send a POST request to projects.json
