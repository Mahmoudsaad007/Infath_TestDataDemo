import InheritancePages.LegalConsultant_Actions;
import InheritancePages.LoginInternal;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
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
        loginInternal.loginInternalUser(UserCredentials.getTestData("Inhert_1_UserName"),
                UserCredentials.getTestData("Inhert_1_Password"));
        loginInternal.OpenInheritancePage("INH0876");
        String Get_ERP_RequestID = loginInternal.getRequestId();
        Validations.assertThat().object(Get_ERP_RequestID).isNotNull().
                withCustomReportMessage("Get_ERP_RequestID is " + Get_ERP_RequestID).perform();



//
//        driver.browser().waitUntilUrlMatches("https://es-qa.infath.sa/Eservices_Internal/TasksListing");
//        Validations.assertThat().browser(driver.getDriver()).url().contains("https://es-qa.infath.sa/Eservices_Internal/TasksListing")
//                .withCustomReportMessage("User is logged in and Home page is displayed successfully").perform();
    }









}
