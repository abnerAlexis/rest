package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class DeleteRequest extends Base {

    @Test
    public void deleteRecord() {
        String path = URL + "api/users/2";
        httpCallManager.deleteRequest(path)
            .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
