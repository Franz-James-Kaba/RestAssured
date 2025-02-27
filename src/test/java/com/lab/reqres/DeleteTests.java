package com.lab.reqres;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.when;
@ExtendWith(AllureJunit5.class)
@Epic("User Management")
@Feature("Delete User")
public class DeleteTests {
    @BeforeAll
    static void setup(){
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void testDelete(){
        when().
                delete("https://reqres.in/api/users/2").
                then().assertThat().statusCode(204);
    }

}
