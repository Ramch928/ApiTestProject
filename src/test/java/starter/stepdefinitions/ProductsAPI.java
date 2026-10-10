package starter.stepdefinitions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * Encapsulates HTTP calls to the product-search API.
 */
public class ProductsAPI {

    private static final String PRODUCT_SEARCH_ENDPOINT =
            "https://waarkoop-server.herokuapp.com/api/v1/search/test/{product}";

    @Step("Search for products matching {0}")
    public void searchByProductName(String product) {
        SerenityRest.given()
                .pathParam("product", product)
                .header("Accept", "application/json")
                .when()
                .get(PRODUCT_SEARCH_ENDPOINT);
    }
}
