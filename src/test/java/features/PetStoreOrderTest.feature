Feature: Test Pet Store Order scenarios

  @petOrderTests
  Scenario Outline: Verify order placed for purchasing the pet
    Given Add Store Order Payload with id "<id>" petid "<petid>" and quantity "<quantity>"
    When user calls "PlaceStoreOrder" with "POST" http request
    Then the API call got success with status code 200
    And verify the order with respective fields <id>, <petid>, <quantity>, <status>, <complete>
    
Examples:
      | id   | petid    | quantity  | status | complete |
      | 1    | 1        | 2         | placed | true     |
      | 2    | 34       | 5         | placed | true     |
      | 10   | 50       | -350      | placed | true     |
      | 9    | -101     | 1500      | placed | true     |
                 

  @petOrderTests
  Scenario Outline: Verify order placed for purchasing the pet with get order
    Given Add Store Order Payload with id "<id>" petid "<petid>" and quantity "<quantity>"
    When user calls "PlaceStoreOrder" with "POST" http request
    Then the API call got success with status code 200
    And user calls "GetStoreOrer" with "GET" http request
    And verify the order with respective fields <id>, <petid>, <quantity>, <status>, <complete>

Examples:
      | id   | petid  | quantity  | status | complete |
      | 7    | 0      | 190       | placed | true     |
      | 7    | 12     | 960       | placed | true     |
      

  @petOrderTests
  Scenario Outline: Verify order response header for purchasing the pet
    Given Add Store Order Payload with id "<id>" petid "<petid>" and quantity "<quantity>"
    When user calls "PlaceStoreOrder" with "POST" http request
    Then the API call got success with status code 200
    And verify the order response header with respective fields "<access-control-allow-headers>", "<access-control-allow-methods>"

 Examples:
      | id   | petid    | quantity  | access-control-allow-headers         | access-control-allow-methods |
      | 1    | 1        | 2         | Content-Type, api_key, Authorization | GET, POST, DELETE, PUT       |
