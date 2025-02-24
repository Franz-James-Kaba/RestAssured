package com.lab.reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DeleteTests {

    @Test
    public void testDelete(){
        when().
                delete("https://reqres.in/api/users/2").
                then().assertThat().statusCode(204);
    }
    @Test
    public void testLogRequestandResponse(){
        given().
                log().all().when().delete("https://reqres.in/api/users/2").then().log().body();
    }
}
