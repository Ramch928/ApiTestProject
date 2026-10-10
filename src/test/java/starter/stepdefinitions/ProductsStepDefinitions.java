package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Cucumber glue for product-search scenarios.
 */
public class ProductsStepDefinitions {

    @Steps
    private ProductsAPI productsApi;

    @When("he calls endpoint with product {word}")
    public void searchForProduct(String product) {
        productsApi.searchByProductName(product);
    }

    @Then("he sees the results displayed for {word}")
    public void shouldFindProduct(String product) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(containsString(product)));
    }

    @Then("he does not see the results for {word}")
    public void shouldNotFindProduct(String product) {
        restAssuredThat(response -> response.statusCode(404));
        restAssuredThat(response -> response.body(containsString("true")));
    }
}
