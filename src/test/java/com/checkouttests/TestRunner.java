package com.checkouttests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/Checkout"
        },
        plugin = {
                "pretty",
                "html:results/html",
                "json:results/json/result.json",
                "junit:results/junit/cucumber.xml"
        },
        monochrome = true
)


public class TestRunner {
}