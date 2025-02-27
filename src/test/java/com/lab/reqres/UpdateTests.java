package com.lab.reqres;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
@Epic("User Management")
@Feature("Update User")
public class UpdateTests {
    @BeforeAll
    static void setup() {
        RestAssured.filters(new AllureRestAssured());
    }

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
