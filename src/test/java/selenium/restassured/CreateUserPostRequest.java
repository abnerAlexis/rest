package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;

public class CreateUserPostRequest extends Base {
    private final static String PATH = URL + "api/users";

    @Test
    public void createUser() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "leader");

        httpCallManager.postRequest(PATH, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("name", is("morpheus"))
            .body("job", is("leader"))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }

    @Test
    public void createJob() {
        HashMap<String, String> body = new HashMap<>();
        body.put("job", "queen");
        httpCallManager.postRequest(PATH, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("job", is("queen"))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }
}
