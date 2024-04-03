import InheritancePages.LoginInternal;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import com.shaft.validation.internal.NativeValidationsBuilder;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginInternalTest {

    private SHAFT.GUI.WebDriver driver;
    private LoginInternal loginInternal;
    private SHAFT.TestData.JSON UserCredentials;


    //Actions
    @BeforeClass(description = "Setup Browser instance")
    public void BeforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        loginInternal = new LoginInternal(driver);
//        evaluatorManager = new SuperUN_Page(driver);
        UserCredentials = new SHAFT.TestData.JSON("UsersCredentials.Json");
        
    }


    @Description("this test is to Open Infath Login page and Login as Supervisor successfully")
    @Test(description = "Login as Supervisor")
    public void loginInternalUserAsManager() {
        loginInternal.loginInternalUser(UserCredentials.getTestData("Super_UserName"),
                UserCredentials.getTestData("Super_Password"));
        driver.browser().waitUntilUrlMatches("https://es-qa.infath.sa/Eservices_Internal/TasksListing");
        Validations.assertThat().
                browser(driver.getDriver()).url().contains("https://es-qa.infath.sa/Eservices_Internal/TasksListing")
                .withCustomReportMessage("User is logged in and Home page is displayed successfully").perform();

//        Validations.assertThat().
//                .url().isEqualTo("https://es-qa.infath.sa/Eservices_Internal/TasksListing")
//                .withCustomReportMessage("User is logged in and Home page is displayed successfully").perform();
    }

//    @Description("Search For Task Number and Assign Specialist")
//    @Test(description = "Verify that the user Assign Specialist successfully")
//    public void Assign_Specialist() {
//
//    }




    @AfterMethod(description = "Close Browser")
    public void afterClass() {
//        driver.browser().closeCurrentWindow();
        driver.quit();
    }
}
