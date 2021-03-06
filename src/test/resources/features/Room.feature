Feature: Room Resource Test

  @SmokeTest @IntegrationTest
  Scenario Outline: Request GET Room API test
    Given a valid endpoint to fetch rooms
    When the request is send to server with page number as "<page>" to get list of rooms
    Then validate the response of first room record having room number as "<roomName>"
    Examples:
      |page|roomName      |
      | 0  |Elite         |
      | 1  |ParadisePalace|


  @SmokeTest @IntegrationTest
  Scenario Outline: Send a valid Request to get room details
    Given a request endpoint with valid "<id>" id to get room details
    When request is send to the server to get room details
    Then the response will return "<statusCode>" and "<id>" and "<roomName>" of the room
    Examples:
      |statusCode   |id     |roomName     |
      |200          |2      |Vipers       |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request Room Update API test
    Given the valid endpoint with id of "<id>" to update rooms
    And room detail of "<roomNumber>" and "<roomName>" and "<roomCapacity>" and "<roomLocation>" and "<roomType>" and "<status>" payload to update a room data
    When request is send to the server to update a room
    Then the room must be updated with status code of "<statusCode>" and new email as "<roomName>"
    Examples:
      |id |statusCode |roomNumber    |roomName           |roomCapacity  |roomLocation   |roomType         |status   |
      |9  |200        |700           |Skynet             |32            |Building-8     |Boardroom        |active   |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request Room POST API test
    Given a valid endpoint to create rooms
    And a valid payload of "<roomNumber>" and "<roomName>" and "<roomCapacity>" and "<roomLocation>" and "<roomType>" and "<status>" room
    When request is send to the server to create room
    Then the new user must be created with status code of "<statusCode>" and room number as "<roomName>"
    Examples:
      |statusCode |roomNumber    |roomName           |roomCapacity  |roomLocation   |roomType         |status   |
      |201        |201           |Ideas Pressure     |35            |Building-200   |Auditorium       |active   |
      |201        |301           |Think Space        |40            |Building-300   |Banquet          |active   |
      |201        |401           |Local Landmarks    |30            |Building-400   |Hollow Square    |active   |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request Delete Room API test
    Given the valid endpoint with id of "<id>" to delete a room
    When request is send to the server to delete a room
    Then the room must be deleted with status code of "<statusCode>"
    Examples:
      |id   |statusCode  |
      |12   |204         |

  @SmokeTest @IntegrationTest
  Scenario Outline: Send a valid Request to get available rooms for conference
    Given a room with valid "<id>" is booked for a given duration
    And a valid endpoint to get room availability
    When a request is send with page number as "<page>" to fined room availability
    Then the response will return "<statusCode>" and must not return room with "<id>" and "<roomName>"
    Examples:
      |id |statusCode   |page   |roomName   |
      |2  |200          |0      |Vipers     |
