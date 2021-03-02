Feature: Checkout and Place Order

  Scenario: User enters valid information and Places sucessfull order

    Given User browse products
    When User enters valid information to place order
    Then Order is Placed
    
  
