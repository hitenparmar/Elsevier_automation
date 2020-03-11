@Test
Feature: As a customer, i would like to add the summer product to cart so that i can buy the product

  @Test_1
  Scenario: Add Summer dress to cart and try to sign in
    Given I am on HomePage
    When I go to summer dress section
    And I add dress to cart
    Then  I see popup message with dress added to cart
    When I select proceed to checkout from popup
    Then I see shopping-cart summary page
    When I select proceed to checkout
    Then I see Authentication page