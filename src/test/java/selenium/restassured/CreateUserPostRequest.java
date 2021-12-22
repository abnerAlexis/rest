package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.*;

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
    public void createUser_EmptyValues() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "");
        body.put("job", "");

        httpCallManager.postRequest(PATH, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("name", is(""))
            .body("job", is(""))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }

    @Test
    public void createUser_NullValues() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", null);
        body.put("job", null);

        httpCallManager.postRequest(PATH, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("name", is(nullValue()))
            .body("job", is(nullValue()))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }

    @Test
    public void createUser_NullName() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", null);
        body.put("job", "job");

        httpCallManager.postRequest(PATH, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("name", is(nullValue()))
            .body("job", is("job"))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }

    @Test
    public void createUser_NullJob() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "name");
        body.put("job", null);

        httpCallManager.postRequest(PATH, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("name", is("name"))
            .body("job", is(nullValue()))
            .body("id", isA(String.class))
            .body("createdAt", isA(String.class))
        ;
    }

    @Test
    public void createUser_NoParams() {
        HashMap<String, String> body = new HashMap<>();

        httpCallManager.postRequest(PATH, body)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
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
