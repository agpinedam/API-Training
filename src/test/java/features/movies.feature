Feature: Movies

  Scenario: Get movies
    Given I have the credentials
    When I search all the movies
    Then I get a list of movies
    And I get status code <200>

  Scenario: Get movies 2
    Given I have the credentials
    When I search all the movies
    Then I get a list of movies
    And I get status code <400>

  Scenario: Add a movie
    Given I have the credentials
    And I want add a movie with the next data
      | title      | The Lord of the Rings: The Fellowship of the Ring                                                                                                                                                                                                                                                                                                               |
      | year       | 2001                                                                                                                                                                                                                                                                                                                                                            |
      | runtime    | 2h 59m                                                                                                                                                                                                                                                                                                                                                          |
      | director   | Peter Jackson                                                                                                                                                                                                                                                                                                                                                   |
      | actors     | Elijah Wood,Ian McKellen,Viggo Mortensen,Sean Astin                                                                                                                                                                                                                                                                                                             |
      | plot       | Young hobbit Frodo Baggins, after inheriting a mysterious ring from his uncle Bilbo, must leave his home in order to keep it from falling into the hands of its evil creator. Along the way, a fellowship is formed to protect the ringbearer and make sure that the ring arrives at its final destination: Mt. Doom, the only place where it can be destroyed. |
      | language   | English                                                                                                                                                                                                                                                                                                                                                         |
      | country    | New Zealand,United States                                                                                                                                                                                                                                                                                                                                       |
      | awards     | 9 wins & 21 nominations.                                                                                                                                                                                                                                                                                                                                        |
      | metascore  | 82                                                                                                                                                                                                                                                                                                                                                              |
      | imdbRating | 4.2                                                                                                                                                                                                                                                                                                                                                             |
      | imdbVotes  | 1325465                                                                                                                                                                                                                                                                                                                                                         |
    When I sent all the movie data
    Then I get the movie information
    And I get status code <201>

  Scenario: Change movie rating
    Given I create a movie with default data
    And I get status code <201>
    And I have the movieId
    When I change the movie rating to <"0">