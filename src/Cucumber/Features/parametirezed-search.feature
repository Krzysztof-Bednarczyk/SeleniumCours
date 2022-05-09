Feature: Google search

  Scenario Outline: User can search any keyword
    Given an open browser with google.com website
    When a word <keyword> is entered in input field
    Then the first one should contain the <expectedWord>
    And close webdriver
    Examples:
      | keyword  | expectedWord |
      | selenium | Selenium     |
      | karol    | Karol        |
      | jacek    | Jacek        |
      | cucumber | Cucumber     |