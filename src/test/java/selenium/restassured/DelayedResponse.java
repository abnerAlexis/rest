package selenium.restassured;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import selenium.common.HttpCallManager;

public class DelayedResponse {
    private static HttpCallManager httpCallManager = new HttpCallManager();
    public static final String URL = "https://reqres.in/";
    public static String path = URL + "api/users?delay=3\n";

    @Test
    public static void getList(){
        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .time(Matchers.lessThan(5500L))
        ;
    }
}
