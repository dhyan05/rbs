package com.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/Feature",
        glue = {"com.test","src/test/java/com/test"},
        plugin = {"pretty", "json:cucumber.json"},
        tags = {"@test, ~@run"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
}
