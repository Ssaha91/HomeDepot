Feature: User search for items

  @SeeResult
  Scenario Outline: User should be able to search for items and get result
    Given User search for "<item>"
    Then User should see the result page
    Examples:
      | item  |
      | table |

  @AddToCart
  Scenario Outline: User search for item and add to cart
    Given User search for "<item>"
    And User adds item to cart
    Then User should see item in the cart

    Examples:
      | item  |
      | chair |