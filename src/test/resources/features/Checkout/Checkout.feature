Feature: Checkout and Place Order

  Scenario: Place sucessfull order

    Given User browse products
    When User enters information to place order
    Then Order is Placed