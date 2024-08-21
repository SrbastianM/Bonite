Feature: Purchase around the application
  Background:
    Given the user can see home page
    And the user selects the person icon
    When the user enter de credentials on the register form
      | username   | email                  | password   |
      | 1000329111 | boniteuser@yopmail.com | 12334@Pass |
    Then the user can see the welcome message

    Scenario: Purchase Shoes
      Given the user clicks on the shoes option
      And the user selects the shoes
      When the user can see the name of the shoe
      And the user selects the size of the shoe
      When the user selects add to shop car button
      Then the user can see the product on the shop car page