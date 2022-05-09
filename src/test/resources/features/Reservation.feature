Feature: Reservation Resource Test

  @SmokeTest @IntegrationTest
  Scenario Outline: Request GET Reservation API test
    Given a valid endpoint to fetch reservations
    When the request is send to server with page number as "<page>" to get list of reservations
    Then validate the response of first reservation record having reservation description as "<reservationDescription>"
    Examples:
      |page|reservationDescription  |
      | 0  |Annual General Meeting  |
      | 1  |Quarter Three Planning  |


  @SmokeTest @IntegrationTest
  Scenario Outline: Send a valid Request to get reservation details
    Given a request URL with valid "<id>" id to get reservation details
    When request is send to the server to get reservation details
    Then the response will return "<statusCode>" and "<id>" and "<reservationDescription>" of the reservation
    Examples:
      |statusCode   |id     |reservationDescription     |
      |200          |2      |Sprint Retrospective       |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request Reservation Update API test
    Given the valid endpoint with id of "<id>" to update reservation
    And reservation detail of "<roomId>" and "<userId>" and "<reservationDescription>" and "<status>" payload to update a reservation data
    When request is send to the server to update a reservation
    Then the reservation must be updated with status code of "<statusCode>" and new email as "<reservationDescription>"
    Examples:
      |statusCode |id   |roomId        |userId    |reservationDescription   |status   |
      |200        |7    |7             |7         |Architecture Discussion  |active   |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request Reservation POST API test
    Given a valid endpoint to create reservations
    And a valid payload of "<roomId>" and "<userId>" and "<reservationDescription>" and "<status>" reservation
    When request is send to the server to create reservation
    Then the new reservation must be created with status code of "<statusCode>" and room description as "<reservationDescription>"
    Examples:
      |statusCode |roomId        |userId    |reservationDescription   |status   |
      |201        |9             |9         |Architecture Review      |active   |
      |201        |10            |10        |Strategic Planning       |active   |
      |201        |11            |11        |Knowledge Transition     |active   |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request Delete Reservation API test
    Given the valid endpoint with id of "<id>" to delete a reservation
    When request is send to the server to delete a reservation
    Then the reservation must be deleted with status code of "<statusCode>"
    Examples:
      |id   |statusCode  |
      |8    |204         |

  @SmokeTest @IntegrationTest
  Scenario Outline: Send a valid Request to get booked rooms for a conference
    Given a valid endpoint to get booked rooms
    When a request is send with page number as "<page>" and start date as "<startDate>" and end date as "<endDate>" to fined booked rooms
    Then the response will return "<statusCode>" and must return room count as "<roomCount>" number of rooms
    Examples:
      |page |statusCode   |startDate    |endDate      |roomCount  |
      |0    |200          |2022-05-09   |2022-05-10   |2          |
