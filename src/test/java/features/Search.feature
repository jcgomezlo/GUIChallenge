Feature: Search

  Scenario: Successful Search
    Given the user wants to search for a movie
    When the user enters the title 'Fight Club'
    Then the user should see the movie as the first result