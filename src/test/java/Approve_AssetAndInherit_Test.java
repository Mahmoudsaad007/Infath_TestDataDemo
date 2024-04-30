
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Approve_AssetAndInherit_Test extends TestBase {


    protected static String API_RequestID;

    //Add New Inheritance
    @Description("Test Case to Approve on the New Inheritance")
    @Test(priority = 1, description = "Approval on New Inheritance")
    public void Approve_NewInherit_AndAsset_Func_TST() throws InterruptedException {
        loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_MSaad"),
                UserCredentials.getTestData("Password_MSaad"));

        String loggedIn_UserRole = inheritanceDetails.GetLoggedInUserRole();
        // verify if the logged-in user role is not Inheritance Consultant go to select it
        if (!loggedIn_UserRole.equals("Inheritance_Manager")) {
            inheritanceDetails.SelectRole_Inheritance_Manager();
        }
        Validations.assertThat().object(inheritanceDetails.GetLoggedInUserRole()).contains("Inheritance_Manager").
                withCustomReportMessage("Logged-in user role is now " + loggedIn_UserRole).perform();

        // search by inheritance Number
        inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);

//        inheritanceDetails.SearchByNewInheritance_Number("INH0661");

        if (inheritanceList.GetInheritanceConsultantName().equals("Mahmoud Saad")) {
            inheritanceDetails.SelectRole_Inheritance_Consultant();
//            inheritanceDetails.SearchByNewInheritance_Number("INH0661");
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            // Approve the new inheritance from Inheritance Manager User
            inheritanceList.ApproveInheritance_Details();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.Approve_AssetDetails();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("Omar Sami")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Omar"),
                    UserCredentials.getTestData("Password_Omar"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            // Approve the new inheritance from Inheritance Manager User
            inheritanceList.ApproveInheritance_Details();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.Approve_AssetDetails();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("Mai Sherif")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Mai"),
                    UserCredentials.getTestData("Password_Mai"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            // Approve the new inheritance from Inheritance Manager User
            inheritanceList.ApproveInheritance_Details();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.Approve_AssetDetails();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("Mohamed Latif")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Latif"),
                    UserCredentials.getTestData("Password_Latif"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            // Approve the new inheritance from Inheritance Manager User
            inheritanceList.ApproveInheritance_Details();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.Approve_AssetDetails();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("MarwanTest")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Marwan"),
                    UserCredentials.getTestData("Password_Marwan"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            // Approve the new inheritance from Inheritance Manager User
            inheritanceList.ApproveInheritance_Details();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.Approve_AssetDetails();
        }

        ////////////////////////assert inheritance status after Approve//////////////////////////////
//        inheritanceDetails.SearchByNewInheritance_Number("INH0914");
//        String inheritance_Status_After_Approval = inheritanceDetails.getInheritance_Status();
//
////        Validations.assertThat().object(inheritance_Status_After_Approval)
////                .matchesRegex("قيد تعيين مزود خدمة")
////                .withCustomReportMessage("Inheritance status After Approve is  "
////                        + inheritance_Status_After_Approval).perform();


        // Validate that inheritance status is "قيد الاعتماد"
//        String inheritance_Status_ToBe_ReadyApproval = inheritanceDetails.getInheritance_Status();
//        Validations.assertThat().object(inheritance_Status_ToBe_ReadyApproval)
//                .matchesRegex("قيد اعتماد التركة")
//                .withCustomReportMessage("Inheritance status before approval is " + inheritance_Status_ToBe_ReadyApproval).perform();

    }


}
