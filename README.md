# Api.Ratings.Food.Gov.Uk

This is a sample Back End project providing food ratings summary against a given local authority across UK.
It is developed in Java8, Jersey and Maven.

## Set up the Development Environment

You need to set up your development environment before you can do anything.

Ensure you have `java8 (jdk8.X.X)` and `maven (3.3.X)` installed on your machine

Verify by running `java -version` and `mvn -v` in a terminal/console window.

Older versions produce errors, but newer versions are fine.

## Dependencies

Run `mvn clean install` to install fresh copy of the app locally in `.m2` repository

## Development server

Run `mvn exec:java` for a dev server. It runs `Grizzly server 2.4.0`.

Once started, WADL available at `http://localhost:8080/uk.gov.food.ratings.api/application.wadl`

## Running end-to-end tests

Run `mvn test` to execute the all tests, especially end-to-end tests (`RatingsResourceTest`)

## Notes
All tests and the sample service heavily rely on data injected via `Stub.java` file