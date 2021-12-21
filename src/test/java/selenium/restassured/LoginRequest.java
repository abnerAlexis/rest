package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.is;

public class LoginRequest extends Base {
    private String path = URL + "api/login";

    @Test
    public void loginRequest() {
        HashMap<String, String> body = new HashMap<>();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");

        httpCallManager.postRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("token", is("QpwL5tke4Pnpja7X4"))
        ;
    }

    @Test
    public void loginRequestUnsuccessful() {
        HashMap<String, String> body = new HashMap<>();
        body.put("email", "peter@klaven");

        httpCallManager.postRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("error", is("Missing password"))
        ;
    }
}
