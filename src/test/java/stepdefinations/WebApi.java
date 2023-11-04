package stepdefinations;


import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import pageobject.Pages;
import pojo.Employee;
import pojo.EmployeeResponse;
import utils.api.Payload;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;


import static io.restassured.RestAssured.given;


public class WebApi {

    String name;
    String salary;
    String age;
    Integer id;
    Employee employee;

    Logger log = Logger.getLogger(WebApi.class);
    public WebApi(Pages page) {
        this.page = page;
    }

    private Pages page;



    @Given("user navigates to HrmWebsite for api validation")
    public void user_Navigates_To_Website_HrmForApi() throws InterruptedException, IOException, AWTException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        log.info("entering Orange HRM application URL");
       /* page.LoginForHrmPage1().setLogindetail();
        log.info("entering credential on Orange HRM application");


        Thread.sleep(3000);
        page.AddEmployeeForHrmPage1().clickPIM();
        log.info("clicking PIM On Orange HRM application");
        Thread.sleep(2000);
        page.AddEmployeeForHrmPage1().clickAddEmployee();
        log.info("clicking AddEmployee On Orange HRM application");
        Thread.sleep(4000);


        employee = page.AddEmployeeForHrmPage1().AddEmployeeActions();
        name =  String.valueOf(employee.getName());
        //name = employee.getName();
        age = String.valueOf(employee.getAge());
        salary = String.valueOf(employee.getSalary());
        log.info("entering Orange HRM application details as First Name,lastName, middleName and click save button");
        log.info("Getting Employee details added to application :: " + name + "->" + salary + "->" + age);
        Thread.sleep(3000);

        page.AddEmployeeForHrmPage1().scrool();
        Thread.sleep(3000);
        log.info("scrolled Orange HRM application ");

        page.AddEmployeeForHrmPage1().dropdown();
        log.info("selecting dropdowns on Orange HRM application");


        page.AddEmployeeForHrmPage1().setData();
        log.info("selected data on Hrm application");


        page.AddEmployeeForHrmPage1().SelectRadioButton();
        log.info("Select Radio Button on Hrm");

        page.AddEmployeeForHrmPage1().SelectCheckboxAndSave();
        log.info("Select Smoker checkbox on Hrm");
        Thread.sleep(2000);

        CommonActions.tearDown();
        log.info("closing Orange HRM application ");*/
    }

    @When("user enters credential on Hrm Application and click login button")
    public void UserEnterCredentialForHrm() throws InterruptedException, IOException {
        page.LoginForHrmPage1().setLogindetail();
        //ExtentCucumberAdaptor.getCurrentStep().log(Status.Info, "message");
        log.info("entering credential on Orange HRM application");
    }

    @Given("user clicking PIM On Orange HRM application")
    public void UserClickPimForHrm() throws InterruptedException {
        Thread.sleep(3000);
        page.AddEmployeeForHrmPage1().clickPIM();
        log.info("clicking PIM On Orange HRM application");
        Thread.sleep(2000);
    }
    @Given("user clicking AddEmployee On Orange HRM application")
    public void UserClickAddEmpForHrm() throws InterruptedException {
        page.AddEmployeeForHrmPage1().clickAddEmployee();
        log.info("clicking AddEmployee On Orange HRM application");
        Thread.sleep(4000);
    }

    @When("user entering Orange HRM application details as First Name,lastName, middleName and click save button")
    public void UserEnetrEmpDetailsForHrm() throws IOException, InterruptedException, AWTException {
        employee = page.AddEmployeeForHrmPage1().AddEmployeeActions();
        name =  String.valueOf(employee.getName());
        //name = employee.getName();
        age = String.valueOf(employee.getAge());
        salary = String.valueOf(employee.getSalary());
        log.info("entering Orange HRM application details as First Name,lastName, middleName and click save button");
        log.info("Getting Employee details added to application :: " + name + "->" + salary + "->" + age);
        Thread.sleep(3000);
    }
    @And("user scrolled Orange HRM application")
    public void UserScrollOnHrm() throws InterruptedException {
        page.AddEmployeeForHrmPage1().scrool();
        Thread.sleep(3000);
        log.info("scrolled Orange HRM application ");
    }
    @And ("user selecting dropdowns on Orange HRM application")
    public void UserSelectDropdownHrm() throws InterruptedException {
        page.AddEmployeeForHrmPage1().dropdown();
        log.info("selecting dropdowns on Orange HRM application");
    }
    @Then("User selected data on Hrm application")
    public void UserSelectData() throws InterruptedException {
        page.AddEmployeeForHrmPage1().setData();
        log.info("selected data on Hrm application");
    }
    @And  ("user Select Radio Button on Hrm")
    public void UserSelectRadioButton(){
        page.AddEmployeeForHrmPage().SelectRadioButton();
        log.info("successfully selected radio button");

    }
    @Then ("user Select Smoker checkbox on Hrm")
    public void UserSelectCheckBox() throws InterruptedException {
        page.AddEmployeeForHrmPage1().SelectCheckboxAndSave();
        log.info("Select Smoker checkbox on Hrm");
        Thread.sleep(2000);
    }

    @Then("the API post call will get success with expected validation")
    public void theAPICallWillGetSuccessWithExpectedValidation() {
        RestAssured.baseURI = "https://dummy.restapiexample.com";

        EmployeeResponse response = given().relaxedHTTPSValidation().log().all()
                .body(Payload.addEmployee(name, salary, age))
                .when().post("/api/v1/create")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response()
                .as(EmployeeResponse.class);

        id = response.getData().getId();

        log.info(response.getMessage());

        log.info("The post method has been executed successfully with the ID ::" + id);


        log.info("The get method has been executed successfully and the details are ::");
        log.info("The name of employee   :: " + name);
        log.info("The age of employee    :: " + age);
        log.info("The salary of employee :: " + salary);

    }
}


