import InheritancePages.LegalConsultant_Actions;
import InheritancePages.LoginInternal;
import InheritancePages.Specialist_Actions;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inheritance_DemoFlow {

    private SHAFT.GUI.WebDriver driver;
    private LegalConsultant_Actions legalConsultantActions;
    private LoginInternal loginInternal;
    private SHAFT.TestData.JSON UserCredentials;
    private Specialist_Actions specialistActions;

    //Actions
    @BeforeClass(description = "Setup Browser instance")
    public void BeforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        UserCredentials = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/UsersCredentials.Json");
        loginInternal = new LoginInternal(driver);
        legalConsultantActions = new LegalConsultant_Actions(driver);
        specialistActions = new Specialist_Actions(driver);

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
    @Description("This test is to Assign Specialist By Legal Consultant")
    @Test(priority = 2,dependsOnMethods = "loginInternalUserAsSupervisor")
    public void assignSpecialistByLegalConsultant() throws InterruptedException {
        legalConsultantActions.Assignspecialist();
    }
    @Description("This test is choose User Type")
    @Test(priority = 3, dependsOnMethods = "loginInternalUserAsSupervisor")
    public void chooseUserType() throws InterruptedException {
        specialistActions.selectRoleSpecialist();
    }
    @Description("This test is to open tasks list")
    @Test(priority = 4, dependsOnMethods = "chooseUserType")
    public void openTasksList() throws InterruptedException {
        specialistActions.openTasksList();
    }
    @Description("This test is to open tasks Details")
    @Test(priority = 5, dependsOnMethods = "openTasksList")
    public void openTasksDetails() throws InterruptedException {
        specialistActions.openTasksDetails();
    }
    @Description("This test is to Add tasks Details")
    @Test(priority = 6, dependsOnMethods = "openTasksDetails")
    public void addTaskDetails() throws InterruptedException {
        specialistActions.addTaskDetails();
    }








}
