package API_Base;

import com.shaft.driver.SHAFT;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class Inheritance_API {
    private SHAFT.API apiObject;

    public static final String BaseURL = "https://es-qa.infath.sa/Integration_ERP_API/rest";


    private String SendInheritance_SPToOS = "/Inheritance_Request/SendInheritanceSPToOS";

//    static  int AgreementNumber = 2000;

    // Request ID to be bound by this class value "$('.ERP_Request_ID').val()"


    //constructor
    public Inheritance_API(SHAFT.API apiObject) {
        this.apiObject = apiObject;
    }


    ///****************************************Supported Functions//****************************************
    public JSONObject buildJsonBody(String requestId , String AgreementNumber , String spGUID ) throws JSONException {
        JSONObject jsonBody = new JSONObject();
        JSONObject agreementCopy = new JSONObject();
//        JSONObject spGUID = new JSONObject();
        agreementCopy.put("attachmentType", "pdf");
        agreementCopy.put("attachmentName", "SP");
        agreementCopy.put("attachmentContent", "d2VsY29tZSB0byBJbmZhdGg=");

        jsonBody.put("requestID", requestId);
        jsonBody.put("agreementNumber", "PO-" + AgreementNumber);
        jsonBody.put("agreementCopy", agreementCopy); // If agreementCopy is nested
        jsonBody.put("agreementDate", "2024-02-15");
        jsonBody.put("spGUID", spGUID);

//        "spGUID": "c772a9b0-267e-ea11-b8fe-825c1f79d6c4"  //>> 7011010654
//        // e529f006-f18d-ea11-b8fa-cec4bf13e2fe >> 1010340560
//        //db589267-92e4-eb11-b915-c9af5da65e1f >>  1010406413


        // Add more key-value pairs as needed
        return jsonBody;
    }

    //to Parse nested Parameter "agreementCopy"
    // which has nested parameter and need to pass it into BuildJson Func
    // to send JsonBody into API function
//    private JSONObject buildAgreementCopy_Value() throws JSONException {
//        // Create a separate method for nested objects
//        JSONObject agreementCopy = new JSONObject();
//        agreementCopy.put("attachmentType", "pdf");
//        agreementCopy.put("attachmentName", "SP");
//        agreementCopy.put("attachmentContent", "d2VsY29tZSB0byBJbmZhdGg");
//        // Add more key-value pairs for agreementCopy
//        return agreementCopy;
//    }

    // Function to set agreementNumber to dynamic integer value started from 4 digits started with 2000 into above
//    private int generateRandomAgreementNumber() {
//        return (int) (Math.random() * (99999 - 10000 + 1) + 10000);
//    }


//    private int generateRandomAgreementNumber() {
////        AgreementNumber = (int) (Math.random() * (99999 - 10000 + 1) + 10000);
////        AgreementNumber++;
//        return AgreementNumber;
//    }

//    private char[] AgreementNumber(int min, int max) {
//        int randomNumber = (int) (Math.random() * (max - min + 1) + min);
//        return String.valueOf(randomNumber).toCharArray();
//    }




    //**********************************************//Methods/Actions//**********************************************
    public Response SendInheritance_SPToOS_API(JSONObject JsonBody) throws JSONException {
        apiObject = new SHAFT.API(BaseURL);
//        JSONObject Request_JsonBody = buildJsonBody(Request_ID, AgreementNumber);
        return apiObject.post(SendInheritance_SPToOS)
                .addHeader("Authorization", "Basic U0E6UEBzc3cwcmRAMTIzNjU0")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept", "*/*")
                .setContentType("application/json")
                .setRequestBody(JsonBody)
                .performRequest();

//                .setRequestBodyFromFile("src/test/resources/testDataFiles/AssignCaseBody.json")

    }}
