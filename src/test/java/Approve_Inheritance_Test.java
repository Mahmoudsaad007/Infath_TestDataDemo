
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Approve_Inheritance_Test extends TestBase {


    protected static String API_RequestID;

    //Add New Inheritance
    @Description("Test Case to Approve on the New Inheritance")
    @Test(priority = 1, description = "Approval on New Inheritance")
    public void Approve_NewInheritance_Func_TST() throws InterruptedException {
        loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_MSaad"),
                UserCredentials.getTestData("Password_MSaad"));

        String loggedIn_UserRole = inheritanceDetails.GetLoggedInUserRole();
        // verify if the logged in user role is not Inheritance Consultant go to select it
        if (!loggedIn_UserRole.equals("Inheritance_Manager")) {
            inheritanceDetails.SelectRole_Inheritance_Manager();
        }
        Validations.assertThat().object(inheritanceDetails.GetLoggedInUserRole()).contains("Inheritance_Manager").
                withCustomReportMessage("Logged in user role is now " + loggedIn_UserRole).perform();

        // get Inheritance Number from Func addNewInheritance_test
        String New_Inheritance_Number = AddNewInheritance_Test.NewCreatedInheritance_Number;

        // search by inheritance Number
        inheritanceDetails.SearchByNewInheritance_Number(New_Inheritance_Number);

        // Approve the new inheritance from Inheritance Manager User
        inheritanceList.ApproveInheritance_Details();
        inheritanceDetails.SearchByNewInheritance_Number(New_Inheritance_Number);

        String inheritance_Status_After_Approval = inheritanceDetails.getInheritance_Status();
        //assert inheritance status after Approve
        Validations.assertThat().object(inheritance_Status_After_Approval)
                .contains("قيد تعيين مزود خدمة")
                .withCustomReportMessage("Inheritance status After Approve is  "
                        + inheritance_Status_After_Approval).perform();
        inheritanceDetails.OpenInheritanceDetails();
        API_RequestID = inheritanceDetails.getRequestId();


    }

//    @Description("Getting Request ID after Adding and Approve Inheritance")
//    @Test(priority = 2, description = "Get Request ID After Approval")
//    public void Get_RequestID_AfterApproval() throws InterruptedException {
//        loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_MSaad"),
//                UserCredentials.getTestData("Password_MSaad"));
////        loginInternal.OpenInheritancePage("INH0914");
//        loginInternal.OpenInheritancePage(AddNewInheritance_Test.NewCreatedInheritance_Number);
//        API_RequestID = inheritanceDetails.getRequestId();
//    }

//********************************Validations lines ***************
    // Validate that inheritance status is "قيد الاعتماد"
//        String inheritance_Status_ToBe_ReadyApproval = inheritanceDetails.getInheritance_Status();
//        Validations.assertThat().object(inheritance_Status_ToBe_ReadyApproval)
//                .matchesRegex("قيد اعتماد التركة")
//                .withCustomReportMessage("Inheritance status before approval is " + inheritance_Status_ToBe_ReadyApproval).perform();

}
