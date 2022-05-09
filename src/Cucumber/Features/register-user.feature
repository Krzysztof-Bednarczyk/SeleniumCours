Feature: Registration

  Scenario Outline: Register new user
    Given user is on home page
    And user clicks signIn button
    And user provides email
    When user fills out form: <firstName> <lastName> <password>
    Then user is successfully registered as <expectedName>
    And browser is closed
    Examples:
      | firstName | lastName    | password  | expectedName |
      | Marian    | Jonak       | superPass | Marian       |
      | Tomasz    | Norek       | lastPass  | Tomasz       |
      | Krzysztof | Kozakiewicz | 154666    | Krzysztof    |