package com.lab.reqres;

import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(AllureJunit5.class)
public class ReadTests {
    @BeforeAll
    static void setup (){
        RestAssured.filters(new AllureRestAssured());
    }
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

}
