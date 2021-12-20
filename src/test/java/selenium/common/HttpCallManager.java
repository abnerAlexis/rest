package selenium.common;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class HttpCallManager {

    public Response getRequest(String url) {
        return given()
            .contentType(ContentType.JSON)
            .when()
            .log().all()
            .get(url)
            .then()
            .log().all()
            .extract().response();
    }

    public Response postRequest(String path, Object body) {
        return given()
            .header("Content-type", "application/json")
            .and()
            .body(body)
            .when()
            .log().all()
            .post(path)
            .then()
            .log().all()
            .extract().response();
    }

    public Response putRequest(String path, Object body) {
        return given()
            .when()
            .contentType(ContentType.JSON)
            .body(body)
            .log().all()
            .put(path)
            .then()
            .log().all()
            .extract().response()
            ;
    }

    public Response patchRequest(String path, Object body) {
        return given()
            .when()
            .contentType(ContentType.JSON)
            .body(body)
            .log().all()
            .patch(path)
            .then()
            .log().all()
            .extract().response()
            ;
    }

    public Response deleteRequest(String path){
        return given()
            .when()
            .log().all()
            .delete(path)
            .then()
            .log().all()
            .extract().response()
            ;
    }
}
