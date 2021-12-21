package selenium.restassured;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DelayedResponse extends Base {

    @Test
    public void getList() {
        String path = URL + "api/users?delay=3\n";
        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .time(Matchers.lessThan(5500L))
        ;
    }
}
