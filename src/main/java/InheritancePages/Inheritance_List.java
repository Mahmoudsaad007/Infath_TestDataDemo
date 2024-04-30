package InheritancePages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Inheritance_List {

    private SHAFT.GUI.WebDriver driver;

    private By AddBtn = By.xpath("//div/button[text()='إضافة تركة جديدة']");
    private By InheritanceConsultant = By.xpath("(//td)[5]/span");
    //private By LoggedInUser = By.xpath("//div/span[@class='font-semi-bold heading6']");
    private By DLLRoles = By.xpath("//div/select");
    private By ViewDet = By.xpath("(//td/a)[1]");
    // private By EditBTN = By.xpath("//div/button");
    // private By Table1 = By.xpath("//table");
    private By Logout_BTN = By.xpath("//div[@class='margin-left-s']/a[@class='OSFillParent']");
    private By UserName = By.xpath("(//span/input)[1]");
    private By Password = By.xpath("(//span/input)[2]");
    private By Login_BTN = By.xpath("//div/button");
    private By CaseSummaryTxtBox = By.xpath("//span/textarea[@id='b4-b18-b2-TextArea_Case_Summarize']");
    private By HiresTxtBox = By.xpath("//span/textarea[@id='b4-b18-b2-TextArea_Heirs']");
    private By ConsultantNotesTxtBox = By.xpath("//span/textarea[@id='b4-b18-b2-TextArea_Consultant_Notes']");
    private By SPTypeDDL = By.xpath("//div[@id='b4-b18-b2-b1-b1-NothingSelectedText']");
    private By SelectAllOption = By.xpath("//div/span/input[@id='b4-b18-b2-b1-b1-Checkbox_SelectAll']");
    private By InsideSaudiArabia = By.xpath("//input[@id='b4-b18-b2-IsFindingsInKSA']");
    private By CashAmountTxt = By.xpath("//input[@id='b4-b18-b2-CashValue']");
    private By TradableStocks_Txt = By.xpath("//input[@id='b4-b18-b2-NumberofTradableStocks']");
    private By NonTradableStocks_Txt = By.xpath("//input[@id='b4-b18-b2-NumberofNon_TradableStocksinCompanies']");
    private By NumberOfProperties_Txt = By.xpath("//input[@id='b4-b18-b2-NumberofProperties']");
    private By NumberOfCasesAgainstHires_Txt = By.xpath("//input[@id='b4-b18-b2-NumberofCasesAgainstHeirsasHeirs']");
    private By NumberOfCasesAgainstInheritance_Txt = By.xpath("//input[@id='b4-b18-b2-NumberofCasesAgainsttheInheritance']");
    private By Vehicles_Txt = By.xpath("//span/textarea[@id='b4-b18-b2-TextArea_Vehicles']");
    private By Movables_Txt = By.xpath("//span/textarea[@id='b4-b18-b2-TextArea_Movables']");
    private By CompaniesAndCommercialIns_Txt = By.xpath("//span/textarea[@id='b4-b18-b2-TextArea_Companies_And_Commercial_Ins']");
    private By Uploader_Upload = By.xpath("//div/input[@id='b4-b18-b2-b14-FileUploadInput']");
    private By Send_BTN = By.xpath("//*[@id=\"b4-b18-b3-Button\"]");
    // another x path "" // "(//div/button)[5]"
    private By Send_BTN2_Top = By.xpath("//*[@id=\"b4-$b2\"]/div[1]/div[1]/div[2]/div[1]/button");


    private By Save_BTN = By.xpath("//*[@id=\"b4-b18-b2-b20-Button\"]/button");
    private By StatusAssertion = By.xpath("(//td/div/span)[1]");
    private By Approve_BTN = By.xpath("//button[ text()='اعتماد' or text()='approve']");
    private By ApproveConf_BTN = By.xpath("//div[@id='b4-b2-b7-Button']/button");

    private By Search_BTN = By.xpath("//*[@id=\"b11-Form1\"]/div/div[5]/button");

    private By InheritanceNumber_SearchField = By.xpath("//div[@class='feedback-message-text']");

    public By Assets_Tab = By.xpath("//*[@id=\"b4-b12-Title\"]/div/span");
    // another x path customized "(//div/div/div/span)[19]"

    public By AssetDetails_ViewBtn = By.xpath("(//td/div/a/span)[1]");

    public By ApproveAsset_BTN = By.xpath("(//div/div/div/button)[1]");

    public By ApproveAssetConfirm_TxtArea = By.xpath("//*[@id=\"b4-b1-b1-TextArea_Return_To_Projects_Notes2\"]");

    public By ApproveAssetConfirm_BTN = By.xpath("//*[@id=\"b4-b1-b1-b6-Button\"]/button");

    //**************Constructor**************//
    public Inheritance_List(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //************Methods*****************************************//

    // Search by inheritance Number
    public void Search_By_Inheritance_Number(String Created_Inheritance_Number) {
        driver.element().type(InheritanceNumber_SearchField, Created_Inheritance_Number);
        driver.element().click(Search_BTN);

    }

    public void ApproveInheritance_Details() throws InterruptedException {
        driver.element()
                .click(ViewDet)
                .isElementClickable(Approve_BTN);
        driver.element()
                .click(Approve_BTN)
                .click(ApproveConf_BTN);
    }

    // approve asset and inheritance
    public void Approve_AssetDetails() throws InterruptedException {
        driver.element()
                .click(ViewDet)
                .click(Assets_Tab)
                .click(AssetDetails_ViewBtn)
                .click(ApproveAsset_BTN)
                .type(ApproveAssetConfirm_TxtArea, "Automated Accepted Asset NOTES")
                .click(ApproveAssetConfirm_BTN);
    }


    // get Inheritance Consultant Name
    public String GetInheritanceConsultantName() {
        return driver.element().getText(InheritanceConsultant);
//             driver.element().getAttribute(InheritanceConsultant,"data-expression")   ;
    }

    public void StudyInheritanceBy_MSaad() throws InterruptedException, AWTException {
        driver.element()
                .click(ViewDet)
                .scrollToElement(CaseSummaryTxtBox)
                .type(CaseSummaryTxtBox, "Automated Test data for Case Summary Txt Box")
                .type(HiresTxtBox, "Automated Test data for Hires Txt Box")
                .type(ConsultantNotesTxtBox, "Test data for Consultant Notes Txt Box")
                .click(SPTypeDDL)
                .click(SelectAllOption)
                .click(InsideSaudiArabia)
                .type(CashAmountTxt, "250")
                .type(TradableStocks_Txt, "350")
                .type(NonTradableStocks_Txt, "111")
                .type(NumberOfProperties_Txt, "222")
                .type(NumberOfCasesAgainstHires_Txt, "123")
                .type(NumberOfCasesAgainstInheritance_Txt, "123")
                .type(Vehicles_Txt, "Test data for Vehicles Txt Box")
                .type(Movables_Txt, "Test data for Movables Txt Box")
                .type(CompaniesAndCommercialIns_Txt, "Test data for Companies And Commercial")
                .typeFileLocationForUpload(Uploader_Upload, "src/test/resources/testDataFiles/test1.jpg")
                .click(Save_BTN);
        Zoom_Out();
        driver.element()
                .clickUsingJavascript(Send_BTN);
//                    .click(Approve_BTN)
//                    .click(ApproveConf_BTN);
    }

    public void StudyInheritanceBy_Omar() throws InterruptedException, AWTException {
        driver.element()
                .click(ViewDet)
                .scrollToElement(CaseSummaryTxtBox)
                .type(CaseSummaryTxtBox, "Automated Test data for Case Summary Txt Box")
                .type(HiresTxtBox, "Automated Test data for Hires Txt Box")
                .type(ConsultantNotesTxtBox, "Test data for Consultant Notes Txt Box")
                .click(SPTypeDDL)
                .click(SelectAllOption)
                .click(InsideSaudiArabia)
                .type(CashAmountTxt, "250")
                .type(TradableStocks_Txt, "350")
                .type(NonTradableStocks_Txt, "111")
                .type(NumberOfProperties_Txt, "222")
                .type(NumberOfCasesAgainstHires_Txt, "123")
                .type(NumberOfCasesAgainstInheritance_Txt, "123")
                .type(Vehicles_Txt, "Test data for Vehicles Txt Box")
                .type(Movables_Txt, "Test data for Movables Txt Box")
                .type(CompaniesAndCommercialIns_Txt, "Test data for Companies And Commercial")
                .typeFileLocationForUpload(Uploader_Upload, "src/test/resources/testDataFiles/test1.jpg")
                .click(Save_BTN);
        Zoom_Out();
        driver.element()
                .clickUsingJavascript(Send_BTN);
//                    .click(Approve_BTN)
//                    .click(ApproveConf_BTN);
    }

    public void StudyInheritanceBy_Mai() throws InterruptedException, AWTException {
        driver.element()
                .click(ViewDet)
                .scrollToElement(CaseSummaryTxtBox)
                .type(CaseSummaryTxtBox, "Automated Test data for Case Summary Txt Box")
                .type(HiresTxtBox, "Automated Test data for Hires Txt Box")
                .type(ConsultantNotesTxtBox, "Test data for Consultant Notes Txt Box")
                .click(SPTypeDDL)
                .click(SelectAllOption)
                .click(InsideSaudiArabia)
                .type(CashAmountTxt, "250")
                .type(TradableStocks_Txt, "350")
                .type(NonTradableStocks_Txt, "111")
                .type(NumberOfProperties_Txt, "222")
                .type(NumberOfCasesAgainstHires_Txt, "123")
                .type(NumberOfCasesAgainstInheritance_Txt, "123")
                .type(Vehicles_Txt, "Test data for Vehicles Txt Box")
                .type(Movables_Txt, "Test data for Movables Txt Box")
                .type(CompaniesAndCommercialIns_Txt, "Test data for Companies And Commercial")
                .typeFileLocationForUpload(Uploader_Upload, "src/test/resources/testDataFiles/test1.jpg")
                .click(Save_BTN);
        Zoom_Out();
        driver.element()
                .clickUsingJavascript(Send_BTN);
        //                    .click(Approve_BTN)
        //                    .click(ApproveConf_BTN);
    }

    public void StudyInheritanceBy_Marwan() throws InterruptedException, AWTException {
        driver.element()
                .click(ViewDet)
                .scrollToElement(CaseSummaryTxtBox)
                .type(CaseSummaryTxtBox, "Automated Test data for Case Summary Txt Box")
                .type(HiresTxtBox, "Automated Test data for Hires Txt Box")
                .type(ConsultantNotesTxtBox, "Test data for Consultant Notes Txt Box")
                .click(SPTypeDDL)
                .click(SelectAllOption)
                .click(InsideSaudiArabia)
                .type(CashAmountTxt, "250")
                .type(TradableStocks_Txt, "350")
                .type(NonTradableStocks_Txt, "111")
                .type(NumberOfProperties_Txt, "222")
                .type(NumberOfCasesAgainstHires_Txt, "123")
                .type(NumberOfCasesAgainstInheritance_Txt, "123")
                .type(Vehicles_Txt, "Test data for Vehicles Txt Box")
                .type(Movables_Txt, "Test data for Movables Txt Box")
                .type(CompaniesAndCommercialIns_Txt, "Test data for Companies And Commercial")
                .typeFileLocationForUpload(Uploader_Upload, "src/test/resources/testDataFiles/test1.jpg")
                .click(Save_BTN);
        Zoom_Out();
        driver.element()
                .clickUsingJavascript(Send_BTN);
        //                    .click(Approve_BTN)
        //                    .click(ApproveConf_BTN);
    }

    //zooming func
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

    public void StudyInheritanceBy_Latif() throws InterruptedException, AWTException {
        driver.element()
                .click(ViewDet)
                .scrollToElement(CaseSummaryTxtBox)
                .type(CaseSummaryTxtBox, "Automated Test data for Case Summary Txt Box")
                .type(HiresTxtBox, "Automated Test data for Hires Txt Box")
                .type(ConsultantNotesTxtBox, "Test data for Consultant Notes Txt Box")
                .click(SPTypeDDL)
                .click(SelectAllOption)
                .click(InsideSaudiArabia)
                .type(CashAmountTxt, "250")
                .type(TradableStocks_Txt, "350")
                .type(NonTradableStocks_Txt, "111")
                .type(NumberOfProperties_Txt, "222")
                .type(NumberOfCasesAgainstHires_Txt, "123")
                .type(NumberOfCasesAgainstInheritance_Txt, "123")
                .type(Vehicles_Txt, "Test data for Vehicles Txt Box")
                .type(Movables_Txt, "Test data for Movables Txt Box")
                .type(CompaniesAndCommercialIns_Txt, "Test data for Companies And Commercial")
                .typeFileLocationForUpload(Uploader_Upload, "src/test/resources/testDataFiles/test1.jpg")
                .click(Save_BTN);
        Zoom_Out();
        driver.element()
                .clickUsingJavascript(Send_BTN);
        //                    .click(Approve_BTN)
        //                    .click(ApproveConf_BTN);
    }

}


