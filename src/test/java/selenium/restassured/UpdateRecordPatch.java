package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;

public class UpdateRecordPatch extends Base{
    private String path = URL + "api/users/2";

    @Test
    public void updateRecordWithPatch() {
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
}
