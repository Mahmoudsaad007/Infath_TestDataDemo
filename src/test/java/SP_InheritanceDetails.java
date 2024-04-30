import InheritancePages.Inheritance_Details;
import InheritancePages.Inheritance_List;
import InheritancePages.LoginExternal;
import InheritancePages.ServiceProvider;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class SP_InheritanceDetails extends TestBase{


    protected static String NewAsset_Number;
    //Open Inheritance Details Page
    @Description("this test is to  Add and Sending Inheritance Details")
    @Test(priority = 1, description = "Sending Inheritance Details")
    public void Sending_Basic_InheritanceDetails() throws InterruptedException, AWTException {
        loginExternal.loginExternalUser(UserCredentials.getTestData("SP2_UserName"),
                UserCredentials.getTestData("SP2_Password"));
        //********************Change Language to be Arabic******************************//
        String ChangeLang_Status = loginExternal.changeLanguage();
        // Validate language changed successfully
//        Validations.verifyThat().object(ChangeLang_Status).contains("مرحباً")
//                .withCustomReportMessage("Language changed successfully into Arabic").perform();

        String New_deedNumber = AddInheritance_Tst_Data.getTestData("AssetType_Properties_deedNumber");


        // get the Inheritance Number from the page Inheritance details to search with it
//        Search and Open Inheritance Details Page
//        serviceProvider.SearchAndOpenInheritance("INH0930");  // to use it as a separated run
        serviceProvider.SearchAndOpenInheritance(AddNewInheritance_Test.NewCreatedInheritance_Number);

        //verify that user is on Inheritance Details Page
        Validations.assertThat().object(serviceProvider.verify_NewInheritanceStatus_BeforeSend())
                .contains("قيد ادخال البيانات من التحالف")
                .withCustomReportMessage("User is on Inheritance Details Page successfully").perform();

        //add Basic inheritance details
        //get the following from Tst Data file
        String BasicInheritance_Name = AddInheritance_Tst_Data.getTestData("Basic_Inheritance_Name");
        String BasicInheritance_Phone = AddInheritance_Tst_Data.getTestData("Basic_Inheritance_Phone");
        String BasicHeirsData_ID = AddInheritance_Tst_Data.getTestData("Basic_HeirsData_ID");

        serviceProvider.Send_BasicInheritanceDetails(BasicInheritance_Name,
                BasicInheritance_Phone,BasicHeirsData_ID);

        //verify that Inheritance Details is sent successfully and status is changed
//        serviceProvider.SearchAndOpenInheritance("INH0585");
        serviceProvider.SearchAndOpenInheritance(AddNewInheritance_Test.NewCreatedInheritance_Number);

//        String InheritanceStatus_AfterSent = serviceProvider.verify_NewInheritanceStatus_AfterSend();
//        Validations.assertThat().object(InheritanceStatus_AfterSent).contains("قيد الاعتماد المبدئي")
//                .withCustomReportMessage("Inheritance Details is sent successfully and status is now "
//                        + InheritanceStatus_AfterSent).perform();

        // Add Asset Property
//        serviceProvider.SearchAndOpenInheritance("INH0931");  // to use it as a separated run

        serviceProvider.Add_AssetType_Properties(New_deedNumber);
        serviceProvider.Select_Send_Asset();
        NewAsset_Number = serviceProvider.getAsset_Number();

        //verify that Inheritance Details is sent successfully "msg is not working propaparly"
//           String SendInheritance_SuccessMsg = serviceProvider.verify_Send_InheritanceSuccessMsg();
//           Validations.assertThat().object(SendInheritance_SuccessMsg).matchesRegex(SendInheritance_SuccessMsg)
//                .withCustomReportMessage("Inheritance Details is sent successfully " + SendInheritance_SuccessMsg ).perform();

    }

    //***********************Add Asset function test TO BE USED Separated later on *********************************//
//
//    @Description("this test is to Add Asset Property")
//    @Test(priority = 2, description = "Add Asset Property")
//    public void Add_AssetType_Properties() throws InterruptedException, AWTException {
//        loginExternal.loginExternalUser(UserCredentials.getTestData("SP2_UserName"),
//                UserCredentials.getTestData("SP2_Password"));
//        //********************Change Language to be Arabic******************************//
//        loginExternal.changeLanguage();
//        // Validate language changed successfully
////        Validations.verifyThat().object(ChangeLang_Status).contains("مرحباً")
////                .withCustomReportMessage("Language changed successfully into Arabic").perform();
//
//        // get the Inheritance Number from the page Inheritance details to search with it
////        Search and Open Inheritance Details Page
//        serviceProvider.SearchAndOpenInheritance("INH0585");
//        serviceProvider.Add_AssetType_Properties("121000000012");
//        serviceProvider.Select_Send_Asset();
//        NewAsset_Number = serviceProvider.getAsset_Number();
//    }


}
