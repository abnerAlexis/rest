package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import selenium.common.HttpCallManager;
import java.util.HashMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;

public class SuccessfulRegistry {
    private static final HttpCallManager httpCallManager = new HttpCallManager();
    private String URL = "https://reqres.in/";
    private  String path =  URL + "api/register";

    @Test
    public void registerSuccessful(){
        HashMap<String, String> body = new HashMap<>();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "pistol");

        httpCallManager.postRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("id", isA(Integer.class))
            .body("token", isA(String.class))
        ;
    }

    @Test
    public void registerUnsuccessful(){
        HashMap<String, String> body = new HashMap<>();
        body.put("email", "eve.holt@reqres.in");

        httpCallManager.postRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("error", is("Missing password"))
        ;
    }
}
