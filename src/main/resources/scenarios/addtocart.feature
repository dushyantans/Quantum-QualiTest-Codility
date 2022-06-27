@Web
Feature: Katalon Shopping

  @addToCart
  Scenario: Add items to cart
    Given I open browser to webpage "https://cms.demo.katalon.com/"
    And I add 4 randon items to cart
    When I view my cart
    Then I find total 4 items listed in my cart
    When I search for lowest price item
    And I am able to remove the lowest price item from my cart
    Then I find total 3 items listed in my cart
  
    
    
