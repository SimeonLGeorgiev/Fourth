@login
Feature: Test eBay Prices

  Scenario: eBay Basket Price Matching Test: Checking Cost for Two Identical Products
    Given I navigate to eBay main page
    When I verify the page is loaded
    Then I navigate to "Toys & hobbies" page
    And I verify the page is loaded
    And I verify "Toys & hobbies" page is open and search for Monopoly
    And I verify the item has shipping to Bulgaria and the Price is visible
    And I navigate to first item of the list
    And I change to Item tab
    And I verify the page is loaded
    And I verify price is the same as previous page
    And I verify shipping to Bulgaria exist
    And I add to Cart 2 items
    And I verify the page is loaded
    And I verify Checkout page URL, Quantity and Total Price



