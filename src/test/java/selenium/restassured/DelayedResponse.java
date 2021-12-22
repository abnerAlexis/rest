package selenium.restassured;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class DelayedResponse extends Base {

    @Test
    public void getList() {
        String path = URL + "api/users?delay=3\n";
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> emails = Arrays.asList("george.bluth@reqres.in", "janet.weaver@reqres.in", "emma.wong@reqres.in",
                                            "eve.holt@reqres.in", "charles.morris@reqres.in", "tracey.ramos@reqres.in");
        List<String> firstNames = Arrays.asList("George", "Janet", "Emma", "Eve", "Charles", "Tracey");
        List<String> lastNames = Arrays.asList("Bluth", "Weaver", "Wong", "Holt", "Morris", "Ramos");
        List<String> avatars = Arrays.asList("https://reqres.in/img/faces/1-image.jpg", "https://reqres.in/img/faces/2-image.jpg",
                                            "https://reqres.in/img/faces/3-image.jpg", "https://reqres.in/img/faces/4-image.jpg",
                                            "https://reqres.in/img/faces/5-image.jpg", "https://reqres.in/img/faces/6-image.jpg");

        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .time(Matchers.lessThan(5500L))
            .body("page", is(1))
            .body("per_page", is(6))
            .body("total", is(12))
            .body("total_pages", is(2))
            .body("data['id']", is(ids) )
            .body("data['email']", is(emails))
            .body("data['first_name']", is(firstNames))
            .body("data['avatar']", is(avatars))
            .body("support.url", is("https://reqres.in/#support-heading"))
            .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
        ;
    }
}
