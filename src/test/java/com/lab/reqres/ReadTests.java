package com.lab.reqres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class ReadTests {
    @Test
    public void testGetSpecificUser() {
        when().
                get("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                body("data.id", equalTo(2)).
                body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void testContentType(){
        when().get("https://reqres.in/api/users/2").then().assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void testLogRequestandResponse(){
        given().
                log().all().when().get("https://reqres.in/api/users/2").then().log().body();
    }
}
