package api;

import org.json.JSONException;
import org.junit.Test;
import utility.BaseClass;

/**
 * Typically I would add data verification to each call
 * I usually use the base paths to direct the call to specific pieces of data. For example:
 * http://dfiene.fm-development.com:7077/v1/farms/get/"UserID"
 * I then compare the object returned to an array of set data and then assert they match
 * <p>
 * I suspect I could store the Farm object from the Get request in an array and then choose an index
 * to pull a specific farms data from. Then assert that it is correct.
 */

public class PositiveApiTests extends BaseClass {

    /**
     * Sends get request and asserts correct status code is returned
     */
    @Test
    public void getTest200() {
        System.out.println("Get Test");
        getTest(200);
    }

    /**
     * Sends post request and asserts correct status code is returned
     *
     * @throws JSONException
     */
    @Test
    public void postTest200() throws JSONException {
        System.out.println("Post Test");
        postTest(200, 123456789.0987654321, "Precision test ");
    }

    /**
     * Sends put request and asserts correct status code is returned
     *
     * @throws JSONException
     */
    @Test
    public void putTest200() throws JSONException {
        System.out.println("Pull Test");
        putTest(200, "4ac81e3d-7dd7-4774-b694-86e10a1fd864", 123456789, "Oyyyy555555");
    }

    /**
     * Sends delete request and asserts correct status code is returned
     *
     * @throws JSONException
     */
    @Test
    public void deleteTest200() throws JSONException {
        System.out.println("Delete Test");
        deleteTest(200, "3736621a-5eb7-43e1-ba51-3e447d9de4bc");
    }


}
