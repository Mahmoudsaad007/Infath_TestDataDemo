import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.awt.*;

public class Inherit_DemoFlow_NotUsed extends TestBase {

    AddNewInheritance_Test add_NewInheritance;
    StudyInheritance_TST study_Inheritance;
    Approve_Inheritance_Test approve_Inheritance;
    API_SendInheritance_SPToOS api_sendInheritance_spToOs;


    @Description("this test is to Open Infath Login page and Login as Supervisor successfully")
    @Test(priority = 1, description = "Login as Internal User")
    public void FlowAllInOne () throws InterruptedException, JSONException, AWTException {

        loginInternal.loginInternalUser(UserCredentials.getTestData("UserName_MSaad"),
                UserCredentials.getTestData("Password_MSaad"));
        //verify that user is logged in successfully
        Validations.assertThat().object(loginInternal.LogoutIcon()).isTrue()
                .withCustomReportMessage("User is logged in successfully").perform();
//        = new Inheritance_Details();
        add_NewInheritance = new AddNewInheritance_Test();
        study_Inheritance = new StudyInheritance_TST();
        approve_Inheritance = new Approve_Inheritance_Test();
        api_sendInheritance_spToOs = new API_SendInheritance_SPToOS();

        add_NewInheritance.AddNewInheritance_Func_Tst();
        study_Inheritance.StudyInheritance_Func_TST();
        approve_Inheritance.Approve_NewInheritance_Func_TST();
        api_sendInheritance_spToOs.SendPost_SendInheritance_SPToOS();


    }











}
