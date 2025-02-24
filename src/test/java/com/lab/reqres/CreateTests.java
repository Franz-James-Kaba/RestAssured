package com.lab.reqres;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateTests {


    @Test
    public void testCreateUser() {
        // Create a JSON object with input data
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        given()
                .header("Content-Type", "application/json") // Set content type
                .body(requestBody.toString()) // Send JSON body
                .when()
                .post("https://reqres.in/api/users") // API endpoint
                .then()
                .statusCode(201) // Validate response status
                .body("name", equalTo("morpheus")) // Validate response body
                .body("job", equalTo("leader"));
    }


}
