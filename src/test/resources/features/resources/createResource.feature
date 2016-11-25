Feature: Create Resources

  @deleteResource
  Scenario: Create a resource
    Given  I go to the resource page
    When  I create a resource with the following values
      | NAME                 | monitor           |
      | DISPLAY_NAME         | Monitor for Games |
      | RESOURCE_DESCRIPTION | Samsung Black     |
    Then  The resource is created


