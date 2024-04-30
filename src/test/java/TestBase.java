import API_Base.Inheritance_API;
import InheritancePages.*;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;

public class TestBase {


    // Precondition the Project classes
    protected static SHAFT.GUI.WebDriver driver;
    protected LoginInternal loginInternal;

    protected ServiceProvider serviceProvider;

    protected LoginExternal loginExternal;
    protected SHAFT.TestData.JSON UserCredentials;
    protected SHAFT.TestData.JSON AddInheritance_Tst_Data;
    protected Inheritance_Details inheritanceDetails;
    protected Inheritance_List inheritanceList;
    protected Approve_Inheritance_Test approve_inheritance_test;

    protected Inheritance_API inheritanceApi;


    @BeforeClass(description = "Setup Browser instance")
    public void BeforeClass() {
        SHAFT.API apiObject = new SHAFT.API(Inheritance_API.BaseURL);
        inheritanceApi = new Inheritance_API(apiObject);
        driver = new SHAFT.GUI.WebDriver();
        UserCredentials = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/UsersCredentials.Json");
        AddInheritance_Tst_Data = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/AddInheritance_TestData.Json");
        loginInternal = new LoginInternal(driver);
        loginExternal = new LoginExternal(driver);
        inheritanceDetails = new Inheritance_Details(driver);
        inheritanceList = new Inheritance_List(driver);
        serviceProvider = new ServiceProvider(driver);
        approve_inheritance_test = new Approve_Inheritance_Test();

    }
}
