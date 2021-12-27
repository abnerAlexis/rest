package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.*;

public class UpdateRecordPatch extends Base{
    private String path = URL + "api/users/2";

    @Test
    public void updateRecord() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "zion resident");

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is("morpheus"))
            .body("job", is("zion resident"))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void nullNameAndJob() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", null);
        body.put("job", null);

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is(nullValue()))
            .body("job", is(nullValue()))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void nullName() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", null);
        body.put("job", "zion resident");

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is(nullValue()))
            .body("job", is("zion resident"))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void nullJob() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", null);

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is("morpheus"))
            .body("job", is(nullValue()))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void emptyNameAndJob() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "");
        body.put("job", "");

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is(""))
            .body("job", is(""))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void emptyName() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "");
        body.put("job", "zion resident");

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is(""))
            .body("job", is("zion resident"))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void emptyJob() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "");

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is("morpheus"))
            .body("job", is(""))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void emptyBody() {
        HashMap<String, String> body = new HashMap<>();

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("$", not(hasKey("name")))
            .body("$", not(hasKey("job")))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void noName() {
        HashMap<String, String> body = new HashMap<>();
        body.put("job", "Tattoo Artist");

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("$", not(hasKey("name")))
            .body("job", is("Tattoo Artist"))
            .body("updatedAt", isA(String.class))
        ;
    }

    @Test
    public void noJob() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "Fred");

        httpCallManager.patchRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is("Fred"))
            .body("$", not(hasKey("job")))
            .body("updatedAt", isA(String.class))
        ;
    }
}
