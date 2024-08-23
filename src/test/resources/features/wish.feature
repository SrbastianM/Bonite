Feature: Purchase around the application
  Background:
    Given the user can see home page
    And the user selects the person icon
    When the user enter de credentials on the register form
      | username   | email                  | password   |
      | 1000329111 | boniteuser@yopmail.com | 12334@Pass |
    Then the user can see the welcome message

    Scenario: Add Tree Shoes to Favorites
      Given the user clicks on the shoes option
      And the user can see the options to select
      When the user selects add to shop car button
      Then the user can see the products on the whish list page