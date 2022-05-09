@order
Feature: Test Item Ordering functionality

  Scenario: Check ordering of products with standard_user
    Given user is on login page
    When standard_user has logged in successfully
    Then sort items by order dropdown and verify order
      | order               |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

