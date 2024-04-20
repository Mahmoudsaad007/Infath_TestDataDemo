package API_Base;

import com.shaft.driver.SHAFT;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Infath_API {

    private SHAFT.API apiObject;

    public static final String BaseURL = "https://es-qa.infath.sa/Eservices_Case_Integration_API/rest";

    private final String AssignCase = "/Assign_Case/V2";

    private String UpdateCase = "/Update_Case/V2";


    //****************************************//constructor//****************************************//
    public Infath_API(SHAFT.API apiObject) {
        this.apiObject = apiObject;
    }



    //****************************************//Methods/Actions//****************************************//
    public Response AssignCaseAPI() {
//        apiObject = new SHAFT.API(BaseURL);
//        RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(false));
        return apiObject.post(AssignCase)
                .addHeader("Authorization", "Basic U0E6UEBzc3cwcmRAMTIzNjU0")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept", "*/*")
                .setContentType("application/json")
                .setRequestBodyFromFile("src/test/resources/testDataFiles/AssignCaseBody.json")
//                .enableUrlEncoding(true)
                .performRequest();

    }

    public void UpdateCaseAPI(String CaseRefNumber_NewValue) {
        apiObject = new SHAFT.API(BaseURL);
        HashMap<Object, Object> body = new HashMap<>();
        body.put("caseRefNumber", CaseRefNumber_NewValue);
        body.put( "attachmentName", "General Attachment 1");
        body.put("attachmentContent", "d2VsY29tZSB0byBpbmZhdGg=");
        body.put("attachmentContentType", "application/pdf");
        body.put("taskAttachmentCompleted", "true");

        apiObject.post(UpdateCase)
                .addHeader("Authorization", "Basic U0E6UEBzc3cwcmRAMTIzNjU0")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept", "*/*")
                .setContentType("application/json")
                .setRequestBody(body)
//                .setRequestBodyFromFile("src/test/resources/testDataFiles/UpdateCaseBody.json")
                .performRequest();

    }

//    public void SetCaseRefNumberValue_In_JsonFile(String CaseRefNumber_NewValue) throws JSONException {
//
//        // to convert the java.lang.String to JSONObject
//        JsonPath  jsonPath = new JsonPath(AssignCaseAPI().getBody().asString());
//        JSONObject jsonObject = new JSONObject(jsonPath.toString());
//        System.out.println("jsonObject = " + jsonObject);
//        jsonObject.putOpt("CaseRefNumber", CaseRefNumber_NewValue);
////        jsonObject.putOpt("CaseRefNumber", CaseRefNumber_NewValue);
//
//    }

}
