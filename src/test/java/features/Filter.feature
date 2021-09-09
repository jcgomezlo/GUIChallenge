Feature: Filter

  Scenario: Verify Movie Genre Filter
    Given the user wants to see the top-rated movies
    And the user wants to filter for ‘action’ movies
    When the user applies the ‘action’ filter
    And the user selects any movie
    Then the user should see the genre of the movie includes ‘action’

  Scenario: Sort by Dates on Ascending Order
    Given the user wants to sort top-rated movies by their date
    When the user sorts by date on ascending order
    Then the user should see the dates of the first 4 movies in ascending order