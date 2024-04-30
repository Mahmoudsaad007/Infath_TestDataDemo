import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AddNewInheritance_Test extends TestBase {

    protected static String NewCreatedInheritance_Number;

    //Add New Inheritance
    @Description("Test Case to Add New Inheritance")
    @Test (priority = 1, description = "Add New Inheritance")
    public void AddNewInheritance_Func_Tst() throws InterruptedException {
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_MSaad"),
                    UserCredentials.getTestData("Password_MSaad"));

        String loggedInUserRole = inheritanceDetails.GetLoggedInUserRole();
        // verify if the logged-in user role is not Inheritance Consultant go to select it
        if (!loggedInUserRole.equals("Inheritance_Consultant")) {
            inheritanceDetails.SelectRole_Inheritance_Consultant();
        }
        Validations.assertThat().object(inheritanceDetails.GetLoggedInUserRole()).contains("Inheritance_Consultant").
                withCustomReportMessage("Logged in user role is now " + loggedInUserRole).perform();

        //Add New Inheritance
        inheritanceDetails.AddInheritance(AddInheritance_Tst_Data.getTestData("Inheritance_Name")
                , AddInheritance_Tst_Data.getTestData("Inheritor_Name")
                , AddInheritance_Tst_Data.getTestData("ID_Number"));

        inheritanceDetails.Wait_For_Loading_Inheritance_List();

        // Validation only after create Inheritance get the success message
//        String  Success_Message = inheritanceDetails.getSuccessMsg();
//        Validations.assertThat().object(Success_Message).matchesRegex(Success_Message).
//                withCustomReportMessage("Inheritance added successfully with Success Msg is " + Success_Message).perform();

        //Search by the new added Inheritance name and
        // assert that the inheritance added successfully with status
        inheritanceDetails.Search_By_Inheritance_Name(AddInheritance_Tst_Data.getTestData("Inheritance_Name"));
        // get the inheritance status
//        inheritanceDetails.Search_By_Inheritance_Name("testQa");
        String inheritanceStatus_1 = inheritanceDetails.getInheritance_Status();
        Validations.assertThat().object(inheritanceStatus_1).contains("قيد دراسة التركة").
                withCustomReportMessage("Inheritance status is " + inheritanceStatus_1).perform();

        NewCreatedInheritance_Number = inheritanceDetails.getInheritance_Number();
        Validations.assertThat().object(NewCreatedInheritance_Number).isNotNull().
                withCustomReportMessage("New Inheritance number is " + NewCreatedInheritance_Number).perform();


    }

}
