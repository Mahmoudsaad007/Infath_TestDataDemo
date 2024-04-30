package InheritancePages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class LoginInternal {

    //***********************************variables***********************************//
//    protected WebDriver SeleniumDriver;
    private final SHAFT.GUI.WebDriver driver;
    private String InternalURL = "https://es-qa.infath.sa/Eservices_Internal/Login?CurrentLocale=ar-SA" ;
            // "https://es-qa.infath.sa/Eservices_Internal/Login?CurrentLocale=en-US";

//    private String OpenInher_Details_Btn =// Request ID to be bound by this class value "$('.ERP_Request_ID').val()"


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

    public By Logout_Btn = By.xpath("//img[@class='logout_img']");
    public By LoggedIn_UserName = By.xpath("(//div/span)[8]");

    public By InfathLoginMsg = By.xpath("(//h1/label/span)[1]");
    // "//span[@class='text-secondary']"
    // msg in login page "من فضلك قم بتسجيل الدخول"


    public By OpenInhert_Details = By.xpath("//*[@id=\"b12-Main\"]/div[2]/div/table/tbody/tr/td[11]/a");
    public By Inheritance_Num = By.xpath("//*[@id=\"b11-Inheritance_Number\"]");

    public By Search_BTN = By.xpath("//*[@id=\"b11-Form1\"]/div/div[5]/button");



    //*********************************** Actions ***********************************//
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

    // function return log out btn
    public void Logout() {
        driver.element().click(Logout_Btn);
    }

    // function return log out btn icon
    public boolean LogoutIcon() {
        return driver.element().isElementDisplayed(Logout_Btn);
    }



    public String getLoggedInUserName() {
        return driver.element().getText(LoggedIn_UserName);
    }


    // function to verify get  request Id
    public void OpenInheritancePage(Object  Inheritance_Number) {
        driver.element()
                .type(Inheritance_Num, (String) Inheritance_Number)
                .click(Search_BTN)
                .click(OpenInhert_Details);
    }



}
