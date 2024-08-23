Feature: Purchase Products
  Background:
    Given the user can see home page
    And the user selects the person icon
    When the user enter de credentials on the register form
      | username   | email                  | password   |
      | 1000329111 | boniteuser@yopmail.com | 12334@Pass |
    Then the user can see the welcome message

    Scenario: Purchase 5 products product
      Given the user clicks on handbag option
      When the can see the option to select
      And the user selects purchase button
      Then the user can see the products on the shop car page

    Scenario: Purchase one products
      Given the user clicks on belt option
      When the user can see the option to select
      And the user selects options to purchase and select purchase button
      Then the user can see the product on car page