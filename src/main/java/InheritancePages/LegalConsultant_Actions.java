package InheritancePages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class LegalConsultant_Actions {

    //***********************************//variables//***********************************//
//    protected WebDriver SeleniumDriver;
    private final SHAFT.GUI.WebDriver driver;


    //***********************************//Constructor//***********************************//
    public LegalConsultant_Actions(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //***********************************//locators//***********************************//

    public By Assignspecialistcheckbox = By.xpath("//input[@id='b4-l10_0-56_0-Checkbox2']");
    public By Assignspecialistbutton = By.xpath("//button[@id='b4-TasksAssign']");
    public By choosespecialist = By.xpath("(//div/a[@class='display-flex justify-content-flex-end align-items-center'])[2]");
    public By approvebutton = By.xpath("//button[@id='b4-b17-Confirm']");
    public By yesbutton = By.xpath("//button[@class='btn btn-primary ThemeGrid_MarginGutter']");



    //***********************************//Actions//***********************************//

    public void Assignspecialist() throws InterruptedException
    {
//        driver.element().waitToBeReady(Assignspecialistcheckbox);
        driver.element()
                .click(Assignspecialistcheckbox)
                .click(Assignspecialistbutton)
                .waitToBeReady(choosespecialist)
                .click(choosespecialist)
                .click(approvebutton)
                .waitToBeReady(yesbutton)
                .click(yesbutton);
    }


//Selenium code



}
