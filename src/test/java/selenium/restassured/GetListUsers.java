package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class GetListUsers extends Base {

    @Test
    public void getUsers() {
        String path = URL + "api/users?page=2";
        List<Integer> ids = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<String> emails = Arrays.asList(
            "michael.lawson@reqres.in", "lindsay.ferguson@reqres.in",
            "tobias.funke@reqres.in", "byron.fields@reqres.in",
            "george.edwards@reqres.in", "rachel.howell@reqres.in");

        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("page", is(2))
            .body("per_page", is(6))
            .body("total", is(12))
            .body("total_pages", is(2))
            .body("data.size()", is(6))
            .body("data['id']", is(ids))
            .body("data['email']", is(emails))
            .body("support.size()", is(2))
            .body("support['url']", is("https://reqres.in/#support-heading"))
            .body("support['text']", is(notNullValue()))
        ;
    }
}
