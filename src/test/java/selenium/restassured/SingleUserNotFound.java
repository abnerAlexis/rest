package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class SingleUserNotFound extends Base{
    @Test
    public void getSingleResourceNotFound(){
        httpCallManager.getRequest(URL + "api/unknown/23")
            .then()
            .statusCode(HttpStatus.SC_NOT_FOUND)
        ;
    }
}
