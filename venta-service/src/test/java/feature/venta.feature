Feature: Find client by id
  As a user of Wheel Manager
  I Want to find client by id
  So that i can user your data

  Scenario Outline:  the client exists
    Given  i have navigated to the page
    When i find client by <clientId>
    Then  i see the object <id>
    Examples:
      |clientId|id|
      |145454|14554|
      |10|10|
