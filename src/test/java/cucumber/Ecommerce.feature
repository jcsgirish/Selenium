
@tag
Feature: Purchase the order from EcommerceSite
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive Test of the Order
    Given I Logged in with username<name> and password<password>
    When I add items<productName>from cart
    And  Checkout<productName>and submit the order
    Then  <status>verified in the confirmation page

    Examples: 
      | name                   | password       | productName | status                 |
      | Thewizard000@gmail.com | Thewizard0004@ | ZARA COAT 3 | THANKYOU FOR THE ORDER.|
    
