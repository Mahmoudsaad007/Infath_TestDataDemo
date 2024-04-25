import API_Base.Inheritance_API;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class API_SendInheritance_SPToOS {

    private Inheritance_API inheritanceApi;
    public SHAFT.API apiObject;



    @BeforeClass(description = "prepare driver and test data")
    public void beforeClass() {
        SHAFT.API apiObject = new SHAFT.API(Inheritance_API.BaseURL);
        inheritanceApi = new Inheritance_API(apiObject);
//        RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(false));
    }


//    //Actions


    @Description("Send Inheritance SPToOS API Request")
    @Test(priority = 1,description = "Send Inheritance SPToOS API Request")
    public void SendPost_SendInheritance_SPToOS() throws JSONException {
        JSONObject JsonBody_Request = inheritanceApi.buildJsonBody("12330","10001");
        Validations.assertThat().object(JsonBody_Request)
                .isNotNull().withCustomReportMessage("JSON Body request is " + JsonBody_Request).perform();

        Response SPToOS_Response = inheritanceApi.
                SendInheritance_SPToOS_API("12330" , "10001");
        Validations.assertThat().object(SPToOS_Response)
                .isNotNull().withCustomReportMessage("Response is " + SPToOS_Response).perform();

        int ResponseCode = SPToOS_Response.getStatusCode();
//        // verify that request send successfully with status code 200
        SHAFT.Validations.assertThat().number(ResponseCode).isEqualTo(200)
                .withCustomReportMessage("Send Inheritance SPToOS API Request is sent successfully").perform();
        System.out.println("Send Inheritance SPToOS API Request is sent successfully");
    }
}
