# Automation Solution README

## Introduction

This README provides information on the technical requirements and guidelines for developing an automation solution for the web application [https://www.saucedemo.com/](https://www.saucedemo.com/). The automation project should adhere to the specified technical requirements and include automated tests for web application login using Java, Selenium, Cucumber/Gherkin, and Maven.

## Project Setup

Follow these steps to set up the automation project:

1. Clone the repository to your local machine.

2. Ensure you have Java 11 or a later LTS version installed. You can check your Java version using the `java -version` command.

3. Install Maven if it is not already installed. You can download Maven from [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi) and follow the installation instructions.

4. Import the project into your preferred Integrated Development Environment (IDE) that supports Maven.

5. Install the necessary dependencies defined in the `pom.xml` file. You can use Maven to automatically download and manage these dependencies.

6. Set up the chosen reporting tool (e.g., Allure) and integrate it into your project as per its documentation.

## Running Automated Tests

To execute the automated tests and see the allure report, use the following command:

```bash
mvn clean test
mvn allure:report
allure serve target/site/allure-maven-plugin
