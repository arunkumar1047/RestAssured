Feature: BDD+RestAssured

  Scenario: Negative Scenario
    Given Set http request
    When create a negative scenario
    Then print the response into console

  Scenario: Negative Assertion
    Given Set https request
    When create a negative assertion scenario
    Then print the Negative response into console

  Scenario: Future time scenario
    Given Sets http request
    When To get date & Time
    Then print the response in the console
