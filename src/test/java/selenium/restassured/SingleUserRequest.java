package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import selenium.common.HttpCallManager;
import static org.hamcrest.core.Is.is;

public class SingleUserRequest {
    private static final String URL = "https://reqres.in/";
    private final HttpCallManager httpCallManager = new HttpCallManager();
    private static final String path = URL + "api/users/2";

    @Test
    public void getSingleUserId(){
        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.id", is(2))
            .body("data.email", is("janet.weaver@reqres.in"))
            .body("data.first_name", is("Janet"))
            .body("data.last_name", is("Weaver"))
            .body("data.avatar", is("https://reqres.in/img/faces/2-image.jpg"))
            .body("support.url", is("https://reqres.in/#support-heading"))
            .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
        ;
    }
    @Test
    public void getSingleUserNotFound(){
        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_NOT_FOUND)
        ;
    }
}
