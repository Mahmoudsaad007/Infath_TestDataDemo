package MergedRolesPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginExternal {

    //***********************************Variables***********************************//
    private final SHAFT.GUI.WebDriver driver;
//    private SHAFT.GUI.WebDriver driver;
    private String ExternalURL = "https://es-qa.infath.sa/Eservices_External/Login";



    //***********************************Constructor***********************************//
    public LoginExternal(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //***********************************locators***********************************//
    public By Username_External= By.cssSelector( "input[id$='UsernameVal']");
    public By Password_External= By.cssSelector( "#Input_PasswordVal");

    public By Login_Btn= By.cssSelector( "button[class*='btn-large']");


    //***********************************Actions***********************************//
    public void loginExternalUser(String UserName, String Password){
        driver.browser().navigateToURL(ExternalURL);
        driver.element().waitToBeReady(Username_External);
        driver.element()
                .type(Username_External, UserName)
                .type(Password_External, Password)
                .click(Login_Btn);

    }
}
