package com.co.bonbonite.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/features/login.feature",
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        glue = "com.co.bonbonite.stepsdefinitions"
)
public class LoginRunner {
}
