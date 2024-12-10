package com.fakename.runners;

import com.fakename.utils.BeforeSuite;
import com.fakename.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.fakename.stepDefinitions",
        tags = "@Get",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
@RunWith(DataExcelRunner.class)

public class CreateGetNameRunner {

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/createGetName.feature");
    }

}
