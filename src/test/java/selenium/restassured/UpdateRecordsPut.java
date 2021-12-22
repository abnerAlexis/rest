package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;

public class UpdateRecordsPut extends Base {
    private String path = URL + "api/users/2";

    @Test
    public void updateRecordWithPut() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "morpheus");
        body.put("job", "zion resident");

        httpCallManager.putRequest(path, body)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("name", is("morpheus"))
            .body("job", is("zion resident"))
            .body("updatedAt", isA(String.class))
        ;
    }
}
