Feature: Add item from wishlist to Cart.

  Background: 
    Given User Launch the url "https://testscriptdemo.com/"
    
  Scenario: User able to add the lowest price item into the cart
    Given I add "Hard top" different products to my wishlist
    Given I add "Bikini" different products to my wishlist
    Given I add "Modern" different products to my wishlist
    Given I add "Single Shirt" different products to my wishlist
    When i view my wishlist table
    Then i find total four selected items in my wishlist
    When i search for lowest price product
		And i am able to add the lowest price item to my cart
		Then i am able to verify the item in my cart