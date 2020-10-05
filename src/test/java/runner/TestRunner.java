package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "E:\\newRestAssured\\Framework\\src\\test\\resources\\api.feature",
glue= {"stepdefinition"},
tags = "@ft",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true)
public class TestRunner {

}
