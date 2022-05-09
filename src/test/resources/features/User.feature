Feature: User Resource Test

  @SmokeTest @IntegrationTest
  Scenario Outline: Request GET User API test
    Given a valid endpoint to fetch users
    When the request is send to server with page number as "<page>" to get list of users
    Then validate the response of first user record having email as "<emailID>"
    Examples:
      |page|emailID              |
      | 0  |eWarner@gmail.com    |
      | 1  |ethel.moore@yahoo.com|


  @SmokeTest @IntegrationTest
  Scenario Outline: Send a valid Request to get user details
    Given a request endpoint with valid "<id>" id to get user details
    When request is send to the server to get user details
    Then the response will return "<statusCode>" and "<id>" and "<emailId>" of the user
    Examples:
      |statusCode   |id     |emailId                  |
      |200          |2      |Fetterman@gmail.com      |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request User Update API test
    Given the valid endpoint with id of "<id>" to update a users
    And user detail of "<firstName>" and "<lastName>" and "<emailID>" payload to update a user data
    When request is send to the server to update a user
    Then the user must be updated with status code of "<statusCode>" and new email as "<emailID>"
    Examples:
      |id |statusCode |firstName        |lastName         |emailID                |
      |9  |200        |Dean             |Ruiz             |Dean.Ruiz@yahoo.com    |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request User POST API test
    Given a valid endpoint to create users
    And a valid payload of "<firstName>" and "<lastName>" and "<emailID>" user
    When request is send to the server to create user
    Then the new user must be created with status code of "<statusCode>" and email as "<emailID>"
    Examples:
      |statusCode |firstName            |lastName         |emailID              |
      |201        |Davide               |Perdu            |davide@gmail.com     |
      |201        |James                |Coby             |JCoby@gmail.com      |
      |201        |Jim                  |Jordan           |JJordan@gmail.com    |

  @SmokeTest @IntegrationTest
  Scenario Outline: Request Delete User API test
    Given the valid endpoint with id of "<id>" to delete a user
    When request is send to the server to delete a user
    Then the user must be deleted with status code of "<statusCode>"
    Examples:
      |id   |statusCode   |
      |12   | 204         |