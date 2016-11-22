Feature: Create Resources


  Scenario: Create a resource
    Given  I want create a resource
    When I create the resource whit the name: Monitor ,display name: Monitor for Games and description: Samsung Black
    Then  The resource Monitor is created
    And The resource Monitor is deleted
