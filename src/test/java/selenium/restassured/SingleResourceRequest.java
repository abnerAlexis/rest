package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import selenium.common.HttpCallManager;
import static org.hamcrest.core.Is.is;

public class SingleResourceRequest {
    private static final String URL = "https://reqres.in/";
    private static final HttpCallManager httpCallManager = new HttpCallManager();
    private static String path = URL + "api/unknown/2";

    @Test
    public static void getSingleResourceStatusCode(){
        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.id", is(2))
            .body("data.name", is("fuchsia rose"))
            .body("data.year", is(2001))
            .body("data.color", is("#C74375"))
            .body("data.pantone_value", is("17-2031"))
            .body("support.url", is("https://reqres.in/#support-heading"))
            .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
        ;
    }

    @Test
    public static void getSingleResourceNotFound(){
        httpCallManager.getRequest(URL + "api/unknown/23")
            .then()
            .statusCode(HttpStatus.SC_NOT_FOUND)
        ;
    }
}
