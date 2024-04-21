import InheritancePages.LegalConsultant_Actions;
import InheritancePages.LoginInternal;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inheritance_DemoFlow   {

    private SHAFT.GUI.WebDriver driver;
    private LegalConsultant_Actions legalConsultantActions;
    private LoginInternal loginInternal;
    private SHAFT.TestData.JSON UserCredentials;



    //Actions
    @BeforeClass(description = "Setup Browser instance")
    public void BeforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        UserCredentials = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/UsersCredentials.Json");
        loginInternal = new LoginInternal(driver);
        legalConsultantActions = new LegalConsultant_Actions(driver);

    }
    @Description("this test is to Open Infath Login page and Login as Supervisor successfully")
    @Test(priority = 1,description = "Login as Supervisor")
    public void loginInternalUserAsSupervisor() {
        loginInternal.loginInternalUser(UserCredentials.getTestData("Super_UserName"),
                UserCredentials.getTestData("Super_Password"));
//
//        driver.browser().waitUntilUrlMatches("https://es-qa.infath.sa/Eservices_Internal/TasksListing");
//        Validations.assertThat().browser(driver.getDriver()).url().contains("https://es-qa.infath.sa/Eservices_Internal/TasksListing")
//                .withCustomReportMessage("User is logged in and Home page is displayed successfully").perform();
    }









}
