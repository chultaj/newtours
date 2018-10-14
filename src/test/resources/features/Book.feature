Feature: Booking flights on new Mercury Tours site

  Background: Successful login with existing username and password
    Given "Welcome" page is open
    When I provide username and password
      | lah | password |
    And click Sign-In button
    Then "Find a Flight" page opens


  Scenario: Search for a flight for given example dates and destination
    Given "Find a Flight" page is open
    When I provide flight details
      | December 12 | December 19 | San Francisco |
    And I click continue button
    Then "Select a Flight" page opens
    And the result page contains "out" flights
      | Blue Skies Airlines$360$270$5:03 |
      | Blue Skies Airlines$361$271$7:10 |
      | Pangea Airlines$362$274$9:17     |
      | Unified Airlines$363$281$11:24   |
    And the result page contains "in" flights
      | Blue Skies Airlines$630$270$12:23 |
      | Blue Skies Airlines$631$273$14:30 |
      | Pangea Airlines$632$282$16:37     |
      | Unified Airlines$633$303$18:44    |

  Scenario Outline: Search for a given flight and book it
    Given "Find a Flight" page is open
    When I provide flight details: <departure> <return> <destination>
    And I click continue button
    Then "Select a Flight" page opens
    And <flightOut> is on the out flights list
    And <flightIn> is on the in flights list

    When I choose flight <flightOut>
    And I choose flight <flightIn>
    And I click continue button2
    Then "Book a Flight" page opens

    When I click Secure Purchase
    Then "Flight Confirmation" page opens
    And "Your itinerary has been booked!" message is displayed

    Examples:
      | departure   | return      | destination         | flightOut                          | flightIn                         |
      | "December 12" | "December 19" | "Paris"         | "Blue Skies Airlines$360$270$5:03" | "Pangea Airlines$632$282$16:37"  |
      | "January 24"  | "January 30"  | "San Francisco" | "Pangea Airlines$362$274$9:17"     | "Unified Airlines$633$303$18:44" |

#  Scenario Outline: Choose a one way flight
#    Given "Find a Flight" page is open
#    When I provide flight details: <type>
#    And I click continue button
#
#    Examples:
#      | type   |
#      | oneway |