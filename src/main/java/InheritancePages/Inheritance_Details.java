package InheritancePages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.*;

public class Inheritance_Details {
    private SHAFT.GUI.WebDriver driver;

    private By UserRoles_DropDown = By.xpath("//*[@id=\"b2-b3-b2-RolesList2\"]");

    private By AddNewInheritance_BTN = By.xpath("//div/button[text()='إضافة تركة جديدة']");
    //incase change view English //div/button[text()='Add New Inheritance']
    private By InheritanceName_Txt = By.id("b4-b7-b1-InheritanceName");
    private By InheritorName_Txt = By.id("b4-b7-b1-InheritorName");
    private By IDNumber_Txt = By.id("b4-b7-b1-IDNumber");
    private By SelectCourt1_DropDown = By.xpath("//div[@id='b4-b7-b1-Personal_Court-container']/select");
    private By SelectSubCourt1_DropDown = By.xpath("//div[@id='b4-b7-b1-Personal_sub_court-container']/select");
    private By InitialDecision_Txt = By.id("b4-b7-b1-InitialDecisionNumber");
    private By Date_DatePicker = By.xpath("//span/input[@id='b4-b7-b1-b2-Input_DateVar']");
    // private By DatePickerMonth= By.xpath("(//div[@class='calendars-month-header']/select)[1]");
    // private By DatePickerDay = By.xpath("(//td)[10]");
    private By BackBtn_BTN = By.xpath("//div/a[@class='calendars-cmd calendars-cmd-prev ']");
    private By InitialDecisionAttach_Uploader = By.id("b4-b7-b1-b5-FileUploadInput");
    private By CreateBTN_BTN = By.xpath("(//div/button)[2]");
    private By CreateBTN2_BTN = By.xpath("(//div/button)[3]");

    public By InheritanceName_Field = By.xpath("(//div/span/input)[2]");
    //id not working
    public By InheritorNumber_SearchField = By.xpath("(//div/span/input)[3]");
    public By Search_BTN = By.xpath("(//div/button)[1]");
    // another x path  somtimes not working "//*[@id="b11-Form1"]/div/div[5]/button"
    private By Success_Msg = By.xpath("//div[@class='feedback-message-text']");

    private By Fail_Msg = By.xpath("//*[@id=\"feedbackMessageContainer\"]/div/div");

    public By StatusAssertion_FromSearch = By.xpath("(//td/div/span)[1]");
    //    not working >> public By StatusAssertion_Assertion = By.xpath("(//td/div/span)[1]");

    public By New_AddedInheritance_Number = By.xpath("(//tr/td/span)[8]");

    public By ERP_Request_ID = By.xpath("//*[@id=\"b4-b2-Input_Unique_Id\"]");
    public By searched_Inheritance_Name = By.xpath("(//td/span)[4]");

    public By ViewInheritance_Details_BTN = By.xpath("(//td/a)[1]");




    //*********************Constructor*********************//
    public Inheritance_Details(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //*********************Methods*********************//

    //Generate Tst Random Number
    public int generateTstRandomNumber() {
        int generateTstRandomNumber = (int) (Math.random() * (99999 - 10000 + 1) + 10000);
        generateTstRandomNumber++;
        return generateTstRandomNumber;
    }



    // verify user Role
    public String GetLoggedInUserRole() {
        return driver.element().getSelectedText(UserRoles_DropDown);
    }

    // verify user Role SelectInheritanceConsultant
    public void SelectRole_Inheritance_Consultant() {
        driver.element().select(UserRoles_DropDown, "Inheritance_Consultant");
    }

    // verify user Role SelectInheritanceManager
    public void SelectRole_Inheritance_Manager() {
        driver.element().select(UserRoles_DropDown, "Inheritance_Manager");
    }

    public void AddInheritance(String Inheritance_Name, String Inheritor_Name,
                               String ID_Number) throws InterruptedException {
        //  to generate random number of InitialDecision_Txt
        String randomTst_Number = String.valueOf(generateTstRandomNumber());

        driver.element()
                .click(AddNewInheritance_BTN)
                .type(InheritanceName_Txt, Inheritance_Name)
                .type(InheritorName_Txt, Inheritor_Name)
                .type(IDNumber_Txt, ID_Number)
                .select(SelectCourt1_DropDown, "محكمة الأحوال الشخصية بالرياض")
                .select(SelectSubCourt1_DropDown, "دائرة الأحوال الشخصية الأولى")
                .type(InitialDecision_Txt, randomTst_Number)
                .keyPress(Date_DatePicker, Keys.INSERT)
                .hover(BackBtn_BTN)
                .click(BackBtn_BTN)
                .click(BackBtn_BTN)
                .keyPress(Date_DatePicker, Keys.ENTER)
                .typeFileLocationForUpload(InitialDecisionAttach_Uploader,
                        "src/test/resources/testDataFiles/test2.jpg");
        driver.element()
                .performElementAction()
                .click(CreateBTN_BTN)
                .click(CreateBTN2_BTN);
    }

    // waiting to load inheritance list
    public void Wait_For_Loading_Inheritance_List() {
        driver.browser().waitUntilUrlMatches("https://es-qa.infath.sa/Eservices_Internal/Inheritance_Requests");
    }

    // function to search by inheritance Name
    public void Search_By_Inheritance_Name(String Created_Inheritance_Name) {
        driver.element()
                .type(InheritanceName_Field, Created_Inheritance_Name)
                .click(Search_BTN);
    }

    // search by New Inheritance Number
    public void SearchByNewInheritance_Number(String New_Inherit_Number) throws InterruptedException {
        driver.element()
//                .hover(InheritorNumber_SearchField)
                .clear(InheritorNumber_SearchField)
                .type(InheritorNumber_SearchField, New_Inherit_Number)
                .click(Search_BTN);
    }

    // just open Inheritance details
    public void OpenInheritanceDetails() {
        driver.element()
                .click(ViewInheritance_Details_BTN);
    }

//    public String getSearched_Inheritance_Name() {
//        return driver.element().getText(searched_Inheritance_Name);
//    }

    // function to get inheritance status "it's working"
    public String getInheritance_Status() {
        return driver.element().getText(StatusAssertion_FromSearch);
    }

    // function to get inheritance number after search about it
    public String getInheritance_Number() {
        return driver.element().getText(New_AddedInheritance_Number);
    }


    public String getSuccessMsg() {
        return driver.element().getText(Success_Msg);
    }

    // get fail msg
    public String getFailMsg() {
        return driver.element().getText(Fail_Msg);
    }

    public  String getRequestId() {
        return driver.element()
                .clickUsingJavascript(ERP_Request_ID).getText(ERP_Request_ID);

    }

}