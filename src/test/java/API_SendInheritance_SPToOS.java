import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class API_SendInheritance_SPToOS extends TestBase{


    @Description("Send Inheritance SPToOS API Request")
    @Test(priority = 1, description = "Send Inheritance SPToOS API Request")
    public void SendPost_SendInheritance_SPToOS() throws JSONException, InterruptedException {
        // GET Agreement Number from AddInheritance_TestData.Json
        String API_AgreementNumber = AddInheritance_Tst_Data.getTestData("API_SPToOS_AgreementNumber");

//        JSONObject JsonBody_Request = inheritanceApi.buildJsonBody("Mo_578132", API_AgreementNumber);

        // Prepare API Request and Json body for the request
        JSONObject JsonBody_Request = inheritanceApi.buildJsonBody(Approve_Inheritance_Test.API_RequestID, API_AgreementNumber
        ,UserCredentials.getTestData("API_SP2_spGUID"));

        Response SPToOS_Response = inheritanceApi.SendInheritance_SPToOS_API(JsonBody_Request);

        Validations.assertThat().object(SPToOS_Response)
                .isNotNull().withCustomReportMessage("API Send Response is " + SPToOS_Response).perform();

        String Response_Body = SPToOS_Response.getBody().asString();
        String Response_Values = SPToOS_Response.jsonPath().getString("message");


//        // verify that request send successfully with status code 200
        SHAFT.Validations.assertThat().object(Response_Values).contains("Success")
                .withCustomReportMessage("Send Inheritance SPToOS API Request response is " + Response_Body).perform();
    }
}
