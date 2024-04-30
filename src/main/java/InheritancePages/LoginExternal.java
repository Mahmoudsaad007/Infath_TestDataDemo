package InheritancePages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginExternal {

    //***********************************Variables***********************************//
    private final SHAFT.GUI.WebDriver driver;


//    private SHAFT.GUI.WebDriver driver;
    private String ExternalURL = "https://es-qa.infath.sa/Eservices_External/Login";

    public String LoggedIn_External_URL = "https://es-qa.infath.sa/Eservices_External/Inheritance_Requests";


    //***********************************Constructor***********************************//
    public LoginExternal(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //***********************************locators***********************************//
    public By Username_External= By.cssSelector( "input[id$='UsernameVal']");
    public By Password_External= By.cssSelector( "#Input_PasswordVal");

    public By Login_Btn= By.cssSelector( "button[class*='btn-large']");

    public By ChangeLanguage_BTN = By.xpath("(//div/a/span)[1]");
    // another x path "//*[@id="b3-PageLinks"]/a/span"

    public By Welcome_Display = By.xpath("(//div/div//div/span)[9]");
    // another x path "///*[@id="b3-$b1"]/div[1]/div[2]/div[1]/div/span"


    //***********************************Actions***********************************//
    public void loginExternalUser(String UserName, String Password){
        driver.browser().navigateToURL(ExternalURL);
        driver.element()
                .type(Username_External, UserName)
                .type(Password_External, Password)
                .click(Login_Btn);
    }

    // get external url page after logged in
    public String getExternalLoggedIn_Url(){
        return driver.browser()
                .waitUntilUrlMatches(LoggedIn_External_URL)
                .getCurrentURL();
    }

    //func change language after login to be arabic
    public String changeLanguage(){
         return driver.element()
                .click(ChangeLanguage_BTN)
//                .waitToBeInvisible(Welcome_Display)
                .getText(Welcome_Display);
    }

}
