package MergedRolesPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Supervisior_Actions {

    //***********************************//variables//***********************************//
//    protected WebDriver SeleniumDriver;
    private final SHAFT.GUI.WebDriver driver;

    //***********************************//Constructor//***********************************//
    public Supervisior_Actions(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //***********************************//locators//***********************************//

    public By UserRoles = By.xpath("//div[@id='b2-b3-b2-RolesList2-container']/select");
    public By Tasksfrom_SideMenu = By.xpath("(//div[@class='side-list-items ']/span)[5]");
    public By eyeicon = By.xpath("(//i[@class='icon fa fa-eye fa-1x'])[1]");

    public By claimtype = By.xpath("//div[@id='b4-b17-Claim_Type-container']/select");
    public By SaveBTN_1 = By.xpath("(//button[@class='btn btn-primary'])[1]");

    //*** Initial Study Checklists ***//
    public By JudicialDecisionAttached_RadioBTN = By.xpath("//input[@id='b4-b18-RadioButton1-input']");
    public By NumberofAssets_RadioBTN = By.xpath("//input[@id='b4-b18-RadioButton3-input']");
    public By IDsofowner_RadioBTN = By.xpath("//input[@id='b4-b18-RadioButton17-input']");
    public By IsDateofBirth_RadioBTN = By.xpath("//input[@id='b4-b18-RadioButton18-input']");
    public By EstimatedValue_RadioBTN = By.xpath("//input[@id='b4-b18-RadioButton14-input']");
    public By SaveBTN_2 = By.xpath("(//button[@class='btn btn-primary'])[2]");



    //***********************************//Actions//***********************************//
    public void selectRoleSpecialist()
    {
        driver.element().select(UserRoles,"Assignment_Specialist");

    }

    public void openTasksList()
    {
        driver.element().click(Tasksfrom_SideMenu);
    }

    public void openTasksDetails()
    {
        driver.element().click(eyeicon);
    }

    public void addTaskDetails()
    {
        driver.element().select(claimtype,"0");
        driver.element().click(SaveBTN_1);
        driver.element().click(JudicialDecisionAttached_RadioBTN);
        driver.element().click(NumberofAssets_RadioBTN);
        driver.element().click(IDsofowner_RadioBTN);
        driver.element().click(IsDateofBirth_RadioBTN);
        driver.element().click(EstimatedValue_RadioBTN);
        driver.element().click(SaveBTN_2);
    }





}
