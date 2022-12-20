package controllers;

import io.restassured.response.Response;

public class MovieController extends BaseController{
    public Response getAllMovies(){
        String path = "movies";
        return makeGetRequest(path);
    }

    public Response createMovie(String body){
        String path = "movies";
        return makePostRequest(path, body);
    }

    public Response changeMovieId(String movieId, String body){
        String path = "movies/"+ movieId;
        return makePatchRequest(path, body);
    }
}
