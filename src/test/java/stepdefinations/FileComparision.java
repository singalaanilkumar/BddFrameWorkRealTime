package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static FileComparsion.ExcelToTextConvertAndComparsion.*;


public class FileComparision {
    @Given("user will convert excel {string} to text {string} file")
    public void userCallsTheResourceWithMethod(String Excel, String Text) throws IOException {
        ExcelToText(Excel, Text);
    }

    @Then("User will do viceVera using delimiter {string} to {string}")
    public void user_convert_Text_to_Excel(String delimitertext, String ExcelConvert) throws IOException {
        TextToExcelConverter(delimitertext, ExcelConvert);
    }

    @And("user compared the both files data and returned result to excel")
    public void user_compare_the_files_Data() throws IOException, IOException {
        CompareFile(EXCEL_FILE_PATH, TEXT_fILE);
    }


}