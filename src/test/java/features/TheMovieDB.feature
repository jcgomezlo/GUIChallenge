Feature: GUI

    Scenario: Successful Login
      Given the user wants to login
      When the user enters the credentials
      Then the user should be able to login

    Scenario: Failed Login
      Given the user wants to login
      When the user submits invalid credentials
      Then the user should see a red error message
      And the user should see two more error messages

    Scenario: Successful Search
      Given the user wants to search for a movie
      When the user enters the title 'Fight Club'
      Then the user should see the movie as the first result

    Scenario: Verify Movie Genre Filter
      Given the user wants to see the top-rated movies
      And the user wants to filter for ‘action’ movies
      When the user applies the ‘action’ filter
      And the user selects any movie
      Then the user should see the genre of the movie includes ‘action’

    Scenario: Validate Acting Timeline
      Given the user selects a movie with actors
      And the user selects an actor from the top billed cast
      When the user checks the actor’s acting timeline
      Then the title of the movie should be in the timeline

    Scenario: Sort by Dates on Ascending Order
      Given the user wants to sort top-rated movies by their date
      When the user sorts by date on ascending order
      Then the user should see the dates of the first 4 movies in ascending order