Feature: Home Page Feature
  @addToCart @checkoutCart @completeCheckout
  Scenario: Add Items To Cart
    Given User is on Home Page
    And User clicks on add to cart to add item to cart
    And User clicks on cart icon
    Then the user is redirected to the cart screen

  @removeFromCart
  Scenario: Remove Item(s) From Cart
    Given User is on Home Page
    And User clicks on add to cart to add item to cart
    Then User clicks on Remove to remove item from cart

  @filterItems
  Scenario: Filter Products
    Given User is on Home Page
    And User selects the filter "Price (low to high)" to filter the items

  @logout
  Scenario: Logout the logged in user from the website
    Given User is on Home Page
    Then user clicks on side bar icon
    And User clicks on Logout button
    Then user is redirected to login screen