package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import selenium.common.HttpCallManager;
import java.util.HashMap;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;

public class CreateUserPostRequest {
    private final static HttpCallManager httpCallManager = new HttpCallManager();
    private static String URL = "https://reqres.in/";
    private String path = URL + "api/users";

    @Test
    public void createUser(){
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "leader");

        httpCallManager.postRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("name", is("morpheus"))
            .body("job", is("leader"))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }

    @Test
    public void createJob(){
        HashMap<String, String> body = new HashMap<>();
        body.put("job", "queen");
        httpCallManager.postRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("job", is("queen"))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }
}
