package MergedRolesPages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class EvaluatorOrSP_Actions {

    //***********************************//variables//***********************************//
//    protected WebDriver SeleniumDriver;
    private final SHAFT.GUI.WebDriver driver;


    //***********************************//Constructor//***********************************//
    public EvaluatorOrSP_Actions(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //***********************************//locators//***********************************//

    //this is example of using Find Element
    public By UserName_Internal = By.xpath("//input[@id='Input_UsernameVal2']");//tomsmith



    //***********************************//Actions//***********************************//
    public void FunctionNameOrActionName(String name, String password) {

    }


}
