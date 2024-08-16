Feature: Login into Bon Bonite web page

  @registersuccesfull
  Scenario: the user register on the web page
    Given the user can see home page
    And the user selects the person icon
    When the user enter de credentials on the register form
      | Username      | Password       |
      | srodriguezdev | test@MAIL12343 |
    Then the user can see the welcome message
