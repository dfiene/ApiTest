package utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class BaseClass {

    String baseUrl = "http://dfiene.fm-development.com:7077/v1/farms";

    /**
     * REST Assured get call with status code assertion
     *
     * @param statusCodeExpected The status code expected 404,200,201,500 etc
     */
    public void getTest(int statusCodeExpected) {
        RestAssured.baseURI = baseUrl;
        given().
                when().
                get("").
                then().
                statusCode(statusCodeExpected);
        RequestSpecification request = RestAssured.given();
        Response response = request.get("");
        System.out.println("Response body: " + response.body().asString());
        int StatusCode = response.getStatusCode();
        Assert.assertTrue(statusCodeExpected == (StatusCode));
        System.out.println("Actual status code : " + StatusCode);
        System.out.println("Status code Expected: " + statusCodeExpected);//Get Response Body
    }

    /**
     * REST Assured post call with status code assertion
     *
     * @param statusCodeExpected Status code expected to be returned
     * @param acres              number of acres per farm
     * @param farmName           Name of the farm
     * @throws JSONException
     */
    public void postTest(int statusCodeExpected, double acres, String farmName) throws JSONException {


        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("acres", acres);
        requestParams.put("farm_name", farmName);
        request.body(requestParams.toString());
        Response response = request.post("");
        int StatusCode = response.getStatusCode();
        System.out.println("Actual status code : " + StatusCode);
        System.out.println("Status code Expected: " + statusCodeExpected);
        Assert.assertTrue(statusCodeExpected == (StatusCode));


    }


    /**
     * REST Assured put call with status code assertion
     *
     * @param statusCodeExpected Status code expected to be returned
     * @param farmIdToUpdate     ID of farm to be updated (UUID)
     * @param totalAcres         numbers of acres
     * @param farmName           Name of farm
     * @throws JSONException
     */
    public void putTest(int statusCodeExpected, String farmIdToUpdate, float totalAcres,
                        String farmName) throws JSONException {

        RestAssured.baseURI = baseUrl;
        JSONObject requestParams = new JSONObject();
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        requestParams.put("acres", totalAcres);
        requestParams.put("farm_id", farmIdToUpdate);
        requestParams.put("farm_name", farmName);
        request.body(requestParams.toString());
        Response response = request.put("");
        int StatusCode = response.getStatusCode();
        System.out.println("Actual status code : " + StatusCode);
        System.out.println("Status code Expected: " + statusCodeExpected);
        Assert.assertTrue(statusCodeExpected == (StatusCode));


    }

    /**
     * REST Assured delete call with status code assertion
     *
     * @param statusCodeExpected Status code expected to be returned
     * @param farmIdToDelete     Farm ID to delete
     */
    public void deleteTest(int statusCodeExpected, String farmIdToDelete) {

        String urlWorkAround = baseUrl + "?farm_id=" + farmIdToDelete;

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .delete(urlWorkAround);
        int StatusCode = response.getStatusCode();
        System.out.println("Actual status code : " + StatusCode);
        System.out.println("Status code Expected: " + statusCodeExpected);
        Assert.assertTrue(statusCodeExpected == (StatusCode));


    }
}


