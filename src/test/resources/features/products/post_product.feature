Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario Outline: Looking for available products
    When he calls endpoint with product <products>
    Then he sees the results displayed for <products>
    Examples:
      | products |
      | apple    |
      | tofu     |
      | water    |

  Scenario Outline: Looking for response when product not available
    When he calls endpoint with product <products>
    Then he does not see the results for <products>
    Examples:
      | products |
      | car      |
      | bus      |