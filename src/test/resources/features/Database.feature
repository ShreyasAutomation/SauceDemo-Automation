Feature: SQLite Database validation

  @DB_Test1
  Scenario: Validating the query response from SQLite database
    Given SQLite Database connection is set up
    When I hit the query "Select Name from users where age = 25"
    Then I validate the received query response
    Then I close the DB connection
