package test.com.ecommerce.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import main.java.com.ecommerce.app.EcommerceApp;
import main.java.com.ecommerce.app.Product;
import static org.junit.Assert.*;

public class StepDefinitions {

    private EcommerceApp app;
    private String searchTerm;
    private String category;

    @Given("the user is on the home page of the e-commerce app")
    public void givenTheUserIsOnHomePage() {
        app = new EcommerceApp();  // Initialize the app
        app.loadHomePage();  // Assume this method loads the homepage
    }

    @When("the user enters {string} in the search bar and clicks the search button")
    public void whenUserSearchesForProduct(String searchTerm) {
        this.searchTerm = searchTerm;
        app.searchForProduct(searchTerm);  // Assume search method
    }

    @Then("the app should display a list of products related to {string}")
    public void thenAppDisplaysProductsRelatedToSearchTerm(String searchTerm) {
        Product[] products = app.getSearchResults();  // Get search results from app
        assertTrue("No products found", products.length > 0);  // Check that products are returned
        for (Product product : products) {
            assertTrue("Product does not match search term",
                    product.getName().toLowerCase().contains(searchTerm.toLowerCase()));  // Validate search term in product names
        }
    }

    @When("the user selects the {string} category from the category menu")
    public void whenUserSelectsCategory(String category) {
        this.category = category;
        app.selectCategory(category);  // Assume this method selects a category
    }

    @Then("the app should display a list of products in the {string} category")
    public void thenAppDisplaysProductsInCategory(String category) {
        Product[] products = app.getCategoryProducts(category);  // Get category products from app
        assertTrue("No products found in category", products.length > 0);  // Check products in category
        for (Product product : products) {
            assertTrue("Product does not belong to the selected category",
                    product.getCategory().equalsIgnoreCase(category));  // Validate product category
        }
    }

    @Then("the app should display a \"No products found\" message")
    public void thenAppDisplaysNoProductsFoundMessage() {
        String message = app.getNoProductsMessage();  // Get message when no products found
        assertEquals("No products found", message);  // Verify message
    }
}
