Feature: Project order
As a registered user
I want to order a t-shirt online
so that I have the t-shirt confirmation

@test
Scenario: Product Order

Given User is in T-shirt catalog page
When user order a T-shirt
Then user should have those details in order history


  @test
  Scenario: Update my account

    Given User is logged in
    When user goes to personal details
    And user updates his first name
    Then first name should be updated



