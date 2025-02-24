package com.lab.reqres;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateTests {

    @Test
    public void testUpdate() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("Name","MacMillan");
        requestBody.put("job", "Hunter");
        given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .put("https://reqres.in/api/users/4")
                .then()
                .statusCode(200)
                .body("Name", equalTo("MacMillan"))
                .body("job", equalTo("Hunter"));



    }
}
