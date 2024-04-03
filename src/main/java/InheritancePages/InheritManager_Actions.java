package InheritancePages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class InheritManager_Actions {

    //***********************************//variables//***********************************//
//    protected WebDriver SeleniumDriver;
    private final SHAFT.GUI.WebDriver driver;


    //***********************************//Constructor//***********************************//
    public InheritManager_Actions(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //***********************************//locators//***********************************//

    public By UserName_Internal = By.xpath("//input[@id='Input_UsernameVal2']");//tomsmith

    public By Password_Internal = By.xpath("//input[@id='Input_PasswordVal']"); //SuperSecretPassword!

    public By Login_Btn = By.xpath("//div[@class='btn-label OSInline']");//

    public By InfathLoginMsg = By.xpath("//span[@class='text-secondary']");



    //***********************************//Actions//***********************************//
    public void FunctionNameOrActionName(String name, String password) {
        driver.element().waitToBeReady(UserName_Internal);
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
