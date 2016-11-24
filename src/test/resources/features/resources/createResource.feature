Feature: Create Resources


  Scenario: Create a resource
    Given  I want create a resource
    When  I fill the data whit the following values
      | NAME                 | monitor           |
      | DISPLAY_NAME         | Monitor for Games |
      | RESOURCE_DESCRIPTION | Samsung Black     |
    Then  The resource is created
    And The resource is deleted

