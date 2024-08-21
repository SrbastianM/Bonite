Feature: Login into Bon Bonite web page


  Scenario: the user log into Bon bonite
    Given the user can see home page
    And the user selects the person icon
    When the user enter de credentials on the register form
      | username   | email                  | password   |
      | 1000329111 | boniteuser@yopmail.com | 12334@Pass |
    Then the user can see the welcome message