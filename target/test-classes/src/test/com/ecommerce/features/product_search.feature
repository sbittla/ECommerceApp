Feature: Product Search Functionality in E-commerce App

  As a user,
  I want to search for products using keywords or categories,
  So that I can find products that I am interested in purchasing.

  Scenario: Search for products by keyword
    Given the user is on the home page of the e-commerce app
    When the user enters "laptop" in the search bar and clicks the search button
    Then the app should display a list of products related to "laptop"

  Scenario: Search for products by category
    Given the user is on the home page of the e-commerce app
    When the user selects the "Electronics" category from the category menu
    Then the app should display a list of products in the "Electronics" category

  Scenario: No products found for a search term
    Given the user is on the home page of the e-commerce app
    When the user enters "xyz123" in the search bar and clicks the search button
    Then the app should display a "No products found" message
