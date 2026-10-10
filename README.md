# Product Search API Tests

A Java 8 / Maven API test project using Serenity BDD, Cucumber, and REST Assured.

## Prerequisites

- JDK 8 (matching the current compiler target)
- Apache Maven 3.6+
- Network access to `https://waarkoop-server.herokuapp.com`

## Run the tests

Run the full suite and generate the Serenity report:

```bash
mvn clean verify
```

Run the Cucumber runner directly:

```bash
mvn -Dtest=TestRunner test
```

The Serenity HTML report is generated under `target/site/serenity/`. Surefire XML reports are under `target/surefire-reports/`.

## Test coverage

The feature scenarios cover:
- Positive product searches (`apple`, `tofu`, `water`) expecting HTTP 200 and a response containing the requested product.
- Negative product searches (`car`, `bus`) expecting HTTP 404 and the API's current `true` response marker.

These expectations reflect the existing exercise contract. If the API changes its response schema, update the assertions to validate the documented JSON fields rather than response text.

## Configuration and maintenance

The endpoint is currently declared in `ProductsAPI`. For multiple environments, move it to a Maven/Serenity property or environment variable. Do not commit credentials or secrets.

The GitLab pipeline runs `mvn clean verify` and retains Serenity and Surefire reports even when tests fail.

## Notes

- Tests call a live third-party endpoint, so failures can reflect service availability or network conditions as well as code defects.
- The project currently targets Java 8 and uses Serenity BDD 2.6.0. Plan dependency upgrades separately, with compatibility checks and a full test run.
