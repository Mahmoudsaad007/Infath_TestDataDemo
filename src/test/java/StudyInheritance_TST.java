
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class StudyInheritance_TST extends TestBase{

    // Consultant Study inheritance
    @Description("this test is to study the New Inheritance")
    @Test(priority = 1, description = "Study the New Inheritance")
    public void StudyInheritance_Func_TST() throws InterruptedException, AWTException {
        loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_MSaad"),
                UserCredentials.getTestData("Password_MSaad"));

        String loggedInUserRole = inheritanceDetails.GetLoggedInUserRole();
        // verify if the logged-in user role is not Inheritance Manager go to select it
        if (!loggedInUserRole.equals("Inheritance_Manager")) {
            inheritanceDetails.SelectRole_Inheritance_Manager();
        }
        Validations.assertThat().object(inheritanceDetails.GetLoggedInUserRole()).contains("Inheritance_Manager").
                withCustomReportMessage("Logged in user role is now " + loggedInUserRole).perform();

//        String New_InheritanceName = AddInheritance_Tst_Data.getTestData("InheritanceName");
//        inheritanceDetails.Search_By_Inheritance_Name(AddNewInheritance_Test.NewCreatedInheritance_Number);

//        String New_Inheritance_Num = inheritanceDetails.getInheritance_Number();

        inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);

        if (inheritanceList.GetInheritanceConsultantName().equals("Mahmoud Saad")) {
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.StudyInheritanceBy_MSaad();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("Omar Sami")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Omar"),
                    UserCredentials.getTestData("Password_Omar"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.StudyInheritanceBy_Omar();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("Mai Sherif")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Mai"),
                    UserCredentials.getTestData("Password_Mai"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.StudyInheritanceBy_Mai();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("Mohamed Latif")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Latif"),
                    UserCredentials.getTestData("Password_Latif"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.StudyInheritanceBy_Latif();
        }
        else if (inheritanceList.GetInheritanceConsultantName().equals("MarwanTest")) {
            loginInternal.Logout();
            loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_Marwan"),
                    UserCredentials.getTestData("Password_Marwan"));
            inheritanceDetails.SelectRole_Inheritance_Consultant();
            inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);
            inheritanceList.StudyInheritanceBy_Marwan();
        }
        // Validate the inheritance status after studying
        inheritanceDetails.SearchByNewInheritance_Number(AddNewInheritance_Test.NewCreatedInheritance_Number);

        Validations.assertThat().object(inheritanceDetails.getInheritance_Status()).contains("قيد اعتماد التركة")
                .withCustomReportMessage("The inheritance status Now is " + inheritanceDetails.getInheritance_Status()).perform();
    }


}
