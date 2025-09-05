package org.example.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RequestMethodsTest extends BaseTest {
    @Test
    void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .log().body();

    }

    @Test
    void testPostRawText() {
        String body = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .post("post")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void testPutRequest() {
        String body = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void testPatchRequest() {
        String body = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void testDeleteRequest() {
        String body = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .log().body();
    }
}
