package org.dmetzler;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TakeDownResourceTest {

    @Test
    public void testHealthTakeDown() {
        given()
          .when().get("/q/health/live")
          .then()
             .statusCode(200);

        given()
        .when().put("/shoot")
        .then()
           .statusCode(200)
           .body(is("Application should now be irresponsive"));


        given()
        .when().get("/q/health/live")
        .then()
           .statusCode(503);


    }

}