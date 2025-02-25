package com.lab.reqres;

import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(AllureJunit5.class)
public class CreateTests {

    @BeforeAll
    static void setup(){
        RestAssured.filters(new AllureRestAssured());
    }
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
