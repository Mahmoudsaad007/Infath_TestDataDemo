package InheritancePages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ServiceProvider {


    private final SHAFT.GUI.WebDriver driver;
    public By Inheritance_Number = By.id("b12-Inheritance_Number");
    public By Inheritance_search_BTN = By.xpath("(//div/button)[2]");
    public By View_Details_BTN = By.xpath("(//td/a)[1]");
    public By NewInheritanceStatus_AfterOpenPage_TXT = By.xpath("(//td/div/span)[1]");
    public By InheritanceStatus_AfterOpenPage_Assert = By.xpath("//*[@id=\"b5-b2-Main_Details\"]/div[1]/div[2]/span");
    // another x path customized for Status is :"(//div/div/div/span)[15]"]

    public By InheritanceStatus_FromSearch_TXT = By.xpath("(//td/div/span)[1]");
    // another x path customized for Status is :"//*[@id="b13-Main"]/div[1]/div/table/tbody/tr/td[8]/div/span"]

    public By Previous_BTN = By.xpath("//*[@id=\"b5-b1-b7-Previous\"]/button");
    public By Basic_Inhert_Name = By.cssSelector("input[id$='Name']");
    // another x path customized for Name is :"(//div/div/span/input)[1]"] ,//*[@id="b5-b1-b6-Input_Name"]

    public By Basic_Inhert_Phone = By.cssSelector("input[id*='Mobile']");
    // another xpath for Phone is :"(//span/input)[2]"]
    // another x path customized for Phone is :"(//span/input)[2]"] , //*[@id="b5-b1-b6-Input_Mobile_Number"]

    public By Basic_Next_BTN = By.xpath("//*[@id=\"b5-b1-b6-b2-Button\"]/button/span");

    public By Basic_HeirsData_RadioBTN = By.id("b5-b1-b7-b1-RadioButton3-input");
    public By Basic_HeirsData_ID = By.id("b5-b1-b7-b1-ID_Number");
    //another location by x path for ID_Number is : "//*[@id="b5-b1-b7-b1-ID_Number"]"]

    public By Basic_HeirsData_DatePicker = By.xpath("(//div/span/input)[3]");
    // another x path for DatePicker is :"//*[@id="b5-b1-b7-b1-b1-Input_DateVar"]"]

    public By Date_BackBTN = By.xpath("(//a[contains(@title,'Show the previous month')])");
    // another x path for DatePicker is :"/html/body/div[2]/div/div[1]/a[1]"]

    public By Basic_HeirsData_NameTXT = By.id("b5-b1-b7-b1-Name");
    public By Basic_HeirsData_NationalTXT = By.id("b5-b1-b7-b1-Nationality");

    public By Basic_HeirsData_ADD_BTN = By.xpath("//*[@id=\"b5-b1-b7-b1-b8-Button\"]/button");

    public By Basic_HeirsData_NEXT_BTN2 = By.xpath("//*[@id=\"b5-b1-b7-b6-Button\"]/button");

    public By Inheritance_Send_BTN = By.xpath("//*[@id=\"b5-b1-b8-b3-Button\"]/button");

    public By Inheritance_ConfirmSend_BTN = By.xpath("//*[@id=\"b5-b1-b8-b4-Button\"]/button");

    public By Inheritance_SendSuccess_Msg = By.xpath("//*[@id=\"feedbackMessageContainer\"]/div/div");

    public By FirefoxError_CloseIcon = By.xpath("/html/body/div[1]/div/i");

    public By FirefoxError_TXT = By.xpath("/html/body/div[1]/div/div");

    public ServiceProvider(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void SearchAndOpenInheritance(String Inhert_Number) throws InterruptedException {

        driver.element()
                .type(Inheritance_Number, Inhert_Number)
                .click(Inheritance_search_BTN)
                .click(View_Details_BTN);

        //more validation may be added before click on View Btn "will do it later"
    }

    // get inheritance status from search unused other is working
//    public String verifyInheritance_Status_FromSearch() {
//        return driver.element().getText(InheritanceStatus_FromSearch_TXT);
//    }

    public String verify_NewInheritanceStatus_BeforeSend() {
        return driver.element().getText(NewInheritanceStatus_AfterOpenPage_TXT);
    }

    // get status after sent the inheritance and reopen it to verify the status
    public String verify_NewInheritanceStatus_AfterSend() {
        return driver.element().getText(InheritanceStatus_AfterOpenPage_Assert);
    }

    //******************** func to delete TXT field data *****************//
    public void delete_TXT_FieldData() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    //func to close firefox error alert "" need enhancement
    public void close_FirefoxErrorAlert() throws InterruptedException {
        if (driver.element().isElementDisplayed(FirefoxError_CloseIcon)) {
            driver.element()
                    .click(FirefoxError_CloseIcon);
            System.out.println("Alert Msg is closed ");
        } else {
            System.out.println(" No Alert displayed ");
        }
    }

    //zoom in/out
    public void Zoom_Out() throws AWTException {
//        zoom using robot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ADD);
//        robot.keyRelease(KeyEvent.VK_ADD);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    //Func to add Basic inheritance details
    public void Send_BasicInheritanceDetails(String BasicInhert_Name,
                                             String BasicInhert_Phone,
                                             String BasicHeirsData_ID) throws InterruptedException, AWTException {

        driver.element()
                .type(Basic_Inhert_Name, BasicInhert_Name)
                .keyPress(Basic_Inhert_Name, Keys.TAB)
//                .waitToBeInvisible(Basic_Inhert_Phone)
                .type(Basic_Inhert_Phone, BasicInhert_Phone)
                .click(Basic_Next_BTN)
                .click(Basic_HeirsData_RadioBTN)
                .type(Basic_HeirsData_ID, BasicHeirsData_ID)
                .keyPress(Basic_HeirsData_DatePicker, Keys.INSERT)
                .hover(Date_BackBTN)
                .click(Date_BackBTN)
                .click(Date_BackBTN)
                .keyPress(Basic_HeirsData_DatePicker, Keys.ENTER)
                .type(Basic_HeirsData_NameTXT, "QC Team")
                .type(Basic_HeirsData_NationalTXT, "Egyptian")
                .click(Basic_HeirsData_ADD_BTN)
                .click(Basic_HeirsData_NEXT_BTN2)
                .click(Inheritance_Send_BTN)
                .click(Inheritance_ConfirmSend_BTN);
//        ****************
        //Verify if Previous BTN is displayed
//        if (driver.element().isElementDisplayed(Previous_BTN)) {
//            driver.element().click(Previous_BTN)
////                    .hover(Basic_Inhert_Name)
//                    .click(Basic_Inhert_Name);
//            delete_TXT_FieldData();
//
//            driver.element()
//                    .type(Basic_Inhert_Name, BasicInhert_Name)
////                    .hover(Basic_Inhert_Phone)
//                    .click(Basic_Inhert_Phone);
//            delete_TXT_FieldData();
//
//            driver.element()
//                    .type(Basic_Inhert_Phone, BasicInhert_Phone)
//                    .click(Basic_Next_BTN)
//                    .click(Basic_HeirsData_RadioBTN)
//                    .type(Basic_HeirsData_ID,BasicHeirsData_ID)
//                    .keyPress(Basic_HeirsData_DatePicker, Keys.INSERT)
//                    .hover(Basic_Date_BackBTN)
//                    .click(Basic_Date_BackBTN)
//                    .click(Basic_Date_BackBTN)
//                    .keyPress(Basic_HeirsData_DatePicker, Keys.ENTER)
//                    .type(Basic_HeirsData_NameTXT, "QC Team")
//                    .type(Basic_HeirsData_NationalTXT, "Egyptian")
//                    .click(Basic_HeirsData_ADD_BTN)
//                    .click(Basic_HeirsData_NEXT_BTN2)
//                    .click(Inheritance_Send_BTN)
//                    .click(Inheritance_ConfirmSend_BTN);
//
    }


    // get send inheritance Success msg
    public String verify_Send_InheritanceSuccessMsg() {
        return driver.element().getText(Inheritance_SendSuccess_Msg);
    }

    //************************** add Asset Type Locators ***************************//

    public By AddAsset_BTN = By.xpath("//*[@id=\"b5-b2-Assets\"]/div/div/div[2]/div/button");

    public By AssetType_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-AssetType_DDL\"]");

    // another x path "(//div/select)[1]"

    public By DeedNumber = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-Deed_Number\"]");
    public By Deed_DatePicker = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b2-Input_DateVar\"]");

//    public By AssetSubType=By.xpath("//*[@id=\"b5-b2-b2-b2-b4-Input_Property_SubType\"]");

    public By PropertyStatus_Dropdown = By.xpath("//select[@id='b5-b2-b2-b2-b4-Property_Status']");
    // another x path customized "(//div/select)[2]" , another //*[@id="b5-b2-b2-b2-b4-Property_Status"]
    public By DeedType_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-Deed_Type\"]");
    // (//div/select)[3]
    public By DeedRegion_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-Region\"]");
    // (//div/select)[4]
    public By City_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-City\"]");
    // (//div/select)[5]
    public By Input_Area = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-Input_Area\"]");
    // //input[@id='b5-b2-b2-b2-b4-Input_Area']
    public By DeedAttachment_Upload = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b5-FileUploadInput\"]");
    // (//div/div/input)[4]
    public By Status_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-PropertyStatus\"]");
    // (//div/select)[8]
    public By DeedUpdateStatus_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-DeedUpdateStatus\"]");
    // (//div/select)[9] , // //select[@id='b5-b2-b2-b2-b4-DeedUpdateStatus']
    public By RestrictionsDeed_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RestrictionsonDeed\"]");
    // (//div/select)[10]
    public By SourceOwnershipDoc_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-SourceofOwnershipDocument\"]");
    // (//div/select)[11]
    public By IsLocationKnown_No_RadioBTN = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton33-input\"]");
    //(//div/div/div/input)[6]
    public By property_guard_No_RadioBTN = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton34-input\"]");
    public By PropertyEvaluated_Yes_RadioBTN = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton28-input\"]");
    public By EstimatedValue_TXT = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-EstimatedValue\"]");
    public By CanBeInvested_radiobutton = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton36-input\"]");
    public By ObligationsProperty_ClickableDropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b21-b1-NothingSelectedText\"]");

    public By SubClickable_CheckBox = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b21-b1-Checkbox_SelectAll\"]");

    //*[@id=\"b5-b2-b2-b2-b4-RadioButton6-input\"]");
    public By ElMoltzm = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-Obligator\"]");

    public By ElMoltzm_Status = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-ObligatorStatus\"]");

    public By ElMoltzm_Amount = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-ValueofObligationBills\"]");

    public By IsPropertyDeedBooked_radiobutton = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton6-input\"]");
    public By Istheregovernmentdecision_radiobutton = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton12-input\"]");
    public By IsPropertyDeedMortgaged_radiobutton = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton25-input\"]");
    public By IsPropertyDeedWill_radiobutton = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton8-input\"]");
    public By IsPropertyDeedDevotion = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-RadioButton10-input\"]");
    public By InquiryAttachments_Upload = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b29-FileUploadInput\"]");
    public By Report_Upload = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b31-FileUploadInput\"]");


    public By ProcedureCurrentStatus_Dropdown = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b34-Input_ProcedureStatus\"]");
    public By DescriptionofCurrentProcedure = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b34-TextArea_Description\"]");
    public By ProcedureEndDate_Date = By.xpath("//input[@id='b5-b2-b2-b2-b4-b34-Input_FinishDate']");
    // xpath //*[@id="b5-b2-b2-b2-b4-b34-Input_FinishDate"]  //css#b5-b2-b2-b2-b4-b34-Input_FinishDate
    public By Add_BTN = By.xpath("//*[@id=\"b5-b2-b2-b2-b4-b37-Button\"]/button/span");

    public By SelectAsset_CheckBox = By.xpath("(//tr/td/div/div/span/input)[1]");
    // for every check box x path  increase last number "(//tr/td/div/div/span/input)[2]"

    public  By  SelectAsset_CheckBox2 = By.xpath("(//tr/td/div/div/span/input)[2]");
    public By SendAsset_BTN = By.xpath("//*[@id=\"b5-b2-$b12\"]/div[1]/div[2]/div/div[2]/button");

    public By SendAsset_ConfirmBTN = By.xpath("//*[@id=\"b5-b2-b12-b4-Button\"]/button/div[2]");

    public By AssetNumber_InList = By.xpath("(//tr/td/span)[4]");

    // Add Asset type "properties"
    public void Add_AssetType_Properties(String deedNumber) {
        driver.element()
                .click(AddAsset_BTN)
                .keyPress(AssetType_Dropdown,Keys.ENTER)
                .select(AssetType_Dropdown, "عقارات")
                .type(DeedNumber, deedNumber)
                .keyPress(Deed_DatePicker, Keys.INSERT)
                .hover(Date_BackBTN)
                .click(Date_BackBTN)
                .keyPress(Deed_DatePicker, Keys.ENTER)
                .select(PropertyStatus_Dropdown, "فارغ")
                .select(DeedType_Dropdown, "سكني")
                .select(DeedRegion_Dropdown, "المدينة المنورة")
                .select(City_Dropdown, "ينبع")
                .type(Input_Area, "1256")
                .typeFileLocationForUpload(DeedAttachment_Upload, "src/test/resources/testDataFiles/test2.jpg")
                .select(Status_Dropdown, "تم تسليمه الى المركز")
                .select(DeedUpdateStatus_Dropdown, "محدث")
                .select(RestrictionsDeed_Dropdown, "لا يوجد")
                .select(SourceOwnershipDoc_Dropdown, "كتابة العدل")
                .click(IsLocationKnown_No_RadioBTN)
                .click(property_guard_No_RadioBTN)
                .click(PropertyEvaluated_Yes_RadioBTN)
                .type(EstimatedValue_TXT, "2500")
                .click(CanBeInvested_radiobutton)
                .click(ObligationsProperty_ClickableDropdown)
                .click(SubClickable_CheckBox)
                .select(ElMoltzm, "التركة")
                .select(ElMoltzm_Status, "منتهي")
//                .keyPress(ElMoltzm_Status, Keys.TAB)
                .type(ElMoltzm_Amount, "3500")
                .click(IsPropertyDeedBooked_radiobutton)
                .click(Istheregovernmentdecision_radiobutton)
                .click(IsPropertyDeedMortgaged_radiobutton) //if clickable should validate it
                .click(IsPropertyDeedWill_radiobutton)
                .click(IsPropertyDeedDevotion)
                .typeFileLocationForUpload(InquiryAttachments_Upload, "src/test/resources/testDataFiles/test2.jpg")
                .typeFileLocationForUpload(Report_Upload, "src/test/resources/testDataFiles/test1.jpg")
                .keyPress(ProcedureCurrentStatus_Dropdown, Keys.ENTER)
                .select(ProcedureCurrentStatus_Dropdown, "لا يوجد")
                .type(DescriptionofCurrentProcedure, "Automation Description test data ")
                .keyPress(DescriptionofCurrentProcedure, Keys.TAB)
                .keyPress(ProcedureEndDate_Date, Keys.ARROW_UP)
                .keyPress(ProcedureEndDate_Date, Keys.TAB)
                .keyPress(ProcedureEndDate_Date, Keys.ARROW_UP)
                .keyPress(ProcedureEndDate_Date, Keys.TAB)
                .keyPress(ProcedureEndDate_Date, Keys.ARROW_UP)
                .keyPress(ProcedureEndDate_Date, Keys.ARROW_UP)
//                .setValueUsingJavaScript(ProcedureEndDate_Date, "04/24/2025")
                .click(Add_BTN);

    }

    // Select and Send Asset
    public void Select_Send_Asset() {
        driver.element()
                .scrollToElement(AssetNumber_InList);
        // need to check that the element checkbox is existed and clickable in the page
        driver.element()
                .click(SelectAsset_CheckBox)
//                .click(SelectAsset_CheckBox2)
                //to click on every check box put the new x path as per the counted by increase Number in
                // this x path "(//tr/td/div/div/span/input)[2] "
                .click(SendAsset_BTN)
                .click(SendAsset_ConfirmBTN);
    }

    // get the Asset Number in the list
    public String getAsset_Number() {
        return driver.element().getText(AssetNumber_InList);
    }

}



