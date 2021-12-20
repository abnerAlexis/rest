package selenium.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import selenium.common.HttpCallManager;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;

public class ResourceListRequest {
    private static final String URL = "https://reqres.in/";
    private final HttpCallManager httpCallManager = new HttpCallManager();
    private final String path = URL + "api/unknown";

    @Test
    public void getStatusCode(){
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> names = Arrays.asList("cerulean", "fuchsia rose", "true red",
                                            "aqua sky", "tigerlily", "blue turquoise");
        List<Integer> years = Arrays.asList(2000, 2001, 2002, 2003, 2004, 2005);
        List<String> colorCodes = Arrays.asList("#98B2D1", "#C74375", "#BF1932",
                                                "#7BC4C4", "#E2583E", "#53B0AE");
        List<String> pantoneValues = Arrays.asList("15-4020", "17-2031", "19-1664",
                                            "14-4811", "17-1456", "15-5217");
        httpCallManager.getRequest(path)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("page", is(1))
            .body("per_page", is(6))
            .body("total", is(12))
            .body("total_pages", is(2))
            .body("data['id']", is(ids))
            .body("data['name']", is(names))
            .body("data['year']", is(years))
            .body("data['color']", is(colorCodes))
            .body("data['pantone_value']", is(pantoneValues))
            .body("support.url", is("https://reqres.in/#support-heading"))
            .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
        ;
    }
}
