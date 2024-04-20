import API_Base.Infath_API;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APIs_Send {

    private Infath_API infath_api;
//    static String CaseRefNumberValues_fromResponse;

    @BeforeClass(description = "prepare driver and test data")
    public void beforeClass() {
        SHAFT.API apiObject = new SHAFT.API(Infath_API.BaseURL);
        infath_api = new Infath_API(apiObject);
//        RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(false));
    }

    //Actions

    @Description("this test is to send Assign Case Request")
    @Test(priority = 1, description = "Send Assign Case API Request")
    public String SendPost_AssignCase() {
        Response AssignCase_Response = infath_api.AssignCaseAPI();

         String ResponseBody = AssignCase_Response.getBody().asString();
//        String ResponseBody = apiObject.getResponseBody();
        int ResponseCode = AssignCase_Response.getStatusCode();
//        int ResponseCode = apiObject.getResponseStatusCode();
        // verify that request send successfully with status code 200
        SHAFT.Validations.assertThat().number(ResponseCode).isEqualTo(200)
                .withCustomReportMessage("Assign Case API Request is sent successfully").perform();
        
//to verify that response body contains caseRefNumber
//        SHAFT.Validations.assertThat().object(ResponseBody).contains("caseRefNumber")
//                .withCustomReportMessage("Response Body of Assign Case API Request is contain caseRefNumber").perform();

        String CaseRefNumberValues_fromResponse = AssignCase_Response.jsonPath().getString("caseRefNumber");
//        String inheritanceNO_Response = apiObject.getResponseJSONValue("inheritanceNumber");
        SHAFT.Validations.assertThat().object(CaseRefNumberValues_fromResponse).isNotNull()
                .withCustomReportMessage("Assign Case API Request is sent successfully and caseRefNumber Value is "
                        + CaseRefNumberValues_fromResponse).perform();

        // print the response body
        System.out.println("Response Body is =>  " + ResponseBody);

        return CaseRefNumberValues_fromResponse;

    }


    @Description("this test is to send Case Update Request")
    @Test(description = "Send Case Update API Request", priority = 2)
    public void SendPost_UpdateCase() throws JSONException {
        String  CaseRefNumberValues = SendPost_AssignCase();
        infath_api.UpdateCaseAPI(CaseRefNumberValues);
    }








}
