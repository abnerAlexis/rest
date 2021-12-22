package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class SingleResourceNotFound extends Base{

    @Test
    public void getSingleResourceStatusCode() {
        String path = URL + "api/unknown/23";
        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_NOT_FOUND)
        ;
    }
}
