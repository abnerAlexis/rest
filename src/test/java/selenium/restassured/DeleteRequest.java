package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import selenium.common.HttpCallManager;

public class DeleteRequest {
    private static final HttpCallManager httpCallManager = new HttpCallManager();
    private final String URL = "https://reqres.in/";
    private String path = URL + "api/users/2";

    @Test
    public void deleteRecord(){
        httpCallManager.deleteRequest(path)
            .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
