@checkout
Feature: Test checkout functionality

  Scenario: Check items one by one and verify they can be purchased with standard_user
    Given user is on login page
    When standard_user has logged in successfully
    Then add items to cart and verify order
      | item                              | price |
      | Sauce Labs Backpack               | 29.99 |
      | Sauce Labs Bike Light             | 9.99  |
      | Sauce Labs Bolt T-Shirt           | 15.99 |
      | Sauce Labs Fleece Jacket          | 49.99 |
      | Sauce Labs Onesie                 | 7.99  |
      | Test.allTheThings() T-Shirt (Red) | 15.99 |


  Scenario: Check many items and verify the total price with standard_user
    Given user is on login page
    When standard_user has logged in successfully
    Then add items 4 to cart and verify order


