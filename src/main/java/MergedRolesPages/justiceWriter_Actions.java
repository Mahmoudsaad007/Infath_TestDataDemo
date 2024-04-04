package MergedRolesPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class justiceWriter_Actions {

    //***********************************//variables//***********************************//
//    protected WebDriver SeleniumDriver;
    private final SHAFT.GUI.WebDriver driver;

    //***********************************//Constructor//***********************************//
    public justiceWriter_Actions(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //***********************************//locators//***********************************//

    //this is example of using Find Element
    public By UserRoles = By.xpath("//div[@id='b2-b3-b2-RolesList2-container']/select");


    //***********************************//Actions//***********************************//
    public void selectRoleSpecialist()
    {
//        driver.element().select(UserRoles,"Assignment_Specialist");
    }

    public void openTasksList()
    {
//        driver.element().click(Tasksfrom_SideMenu);
    }


    public void addTaskDetails()
    {

    }





}
