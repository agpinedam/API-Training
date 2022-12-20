package controllers;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseController {
    private String baseUri;

    public BaseController() {
        this.baseUri = "http://localhost:3000/";
        RestAssured.baseURI = baseUri;
    }

    protected Response makeGetRequest(String path) {
        return RestAssured.given()
                .when()
                .get( "http://localhost:3000/"+path)
                .then()
                .extract()
                .response();

    }

    protected Response makePostRequest(String path, String body){
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(path)
                .then()
                .extract()
                .response();
    }

    protected Response makePatchRequest(String path, String body){
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .patch(path)
                .then()
                .extract()
                .response();
    }

}
