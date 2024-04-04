package InheritancePages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginInternal {

    //***********************************variables***********************************//
//    protected WebDriver SeleniumDriver;
    private final SHAFT.GUI.WebDriver driver;
    private String InternalURL = "https://es-qa.infath.sa/Eservices_Internal/Login?CurrentLocale=ar-SA" ;
            // "https://es-qa.infath.sa/Eservices_Internal/Login?CurrentLocale=en-US";


    //***********************************Constructor***********************************//
    public LoginInternal(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //***********************************locators***********************************//
    public By UserName_Internal = By.xpath("//input[@id='Input_UsernameVal']");
    //id = Input_UsernameVal2
    //input[@id='Input_UsernameVal']
    public By Password_Internal = By.xpath("//input[@id='Input_PasswordVal']");
//    public By Login_Btn = By.cssSelector("#b2-Button > button");
    public By Login_Btn = By.xpath("//div[@class='btn-label OSInline']");//
    //*[@id="b2-Button"]/button/div[2]
    // div[@class='btn-label OSInline']
    public By InfathLoginMsg = By.xpath("//span[@class='text-secondary']");
    // msg in login page "من فضلك قم بتسجيل الدخول"


    //***********************************Actions***********************************//
    public void loginInternalUser(String name, String password) {
        driver.browser().navigateToURL(InternalURL);
//        driver.element().waitToBeReady(UserName_Internal);
        Validations.assertThat().element(driver.getDriver(), InfathLoginMsg).text().isEqualTo("من فضلك قم بتسجيل الدخول")
                .withCustomReportMessage("Infath Login page is loaded successfully").perform();
        driver.element()
                .type(UserName_Internal, name)
                .type(Password_Internal, password)
                .click(Login_Btn);

    }


//Selenium code

//        public ReportListsPage login( String name, String password) {
//            driver.navigate().to("https://es-qa.infath.sa/Eservices_Internal/Login?CurrentLocale=en-US");
//            WaitFor(UserName_Internal);
//            driver.findElement(UserName_Internal).sendKeys(name);
//            driver.findElement(Password_Internal).sendKeys(password);
//            JsClick(Login_Btn);
////        To delete later
//            return new ReportListsPage(driver);
//        }

}
