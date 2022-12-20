package steps;

import com.google.gson.Gson;
import controllers.MovieController;
import helpers.ObjectBodyFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.Movie;
import org.testng.Assert;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Movies {

    private MovieController movieController = new MovieController();
    private Response response;
    private ObjectBodyFactory objectBodyFactory = new ObjectBodyFactory();
    private String body;
    private Movie movie;
    private Map<String, String> movieData;

    @When("I search all the movies")
    public void iSearchAllTheMovies() {
        this.response = movieController.getAllMovies();
    }

    @Then("I get a list of movies")
    public void iGetAListOfMovies() {
        Map<Object, Object> allMovies = response.jsonPath().getMap("[0]");
        assertThat(allMovies.size(), greaterThan(2));
    }

    @And("I want add a movie with Title")
    public void iWantAddAMovieWithTitle() {

    }

    @And("I want add a movie with the next data")
    public void iWantAddAMovieWithTheNextData(DataTable table) {
        movieData = table.asMap(String.class, String.class);
        this.body = objectBodyFactory.jsonMovie(movieData);
    }

    @When("I sent all the movie data")
    public void iSentAllTheMovieData() {
        this.response = movieController.createMovie(this.body);
    }

    @Then("I get the movie information")
    public void iGetTheMovieInformation() {
        movie = new Gson().fromJson(body, Movie.class);
        assertThat(response.body().asString(), containsString(movie.getTitle()));
        assertThat(response.body().asString(), containsString(movie.getYear()));
        assertThat(response.body().asString(), containsString(movie.getRuntime()));
        assertThat(response.body().asString(), containsString(movie.getDirector()));
        assertThat(response.body().asString(), containsString(movie.getActors()));
        assertThat(response.body().asString(), containsString(movie.getPlot()));
        assertThat(response.body().asString(), containsString(movie.getLanguage()));
        assertThat(response.body().asString(), containsString(movie.getCountry()));
        assertThat(response.body().asString(), containsString(movie.getAwards()));
        assertThat(response.body().asString(), containsString(movie.getMetascore()));
        assertThat(response.body().asString(), containsString(movie.getImdbRating()));
        assertThat(response.body().asString(), containsString(movie.getImdbVotes()));
        assertThat(response.body().jsonPath().get("id"), notNullValue());
    }

    @Given("I create a movie with default data")
    public void iCreateAMovieWithDefaultData() {
        body = objectBodyFactory.defaultJsonMovie();
        response = movieController.createMovie(body);
    }

    @And("I get status code <{int}>")
    public void iGetStatusCode(int statusCode) {
        Assert.assertEquals(this.response.statusCode(), statusCode);
    }

    @And("I have the movieId")
    public String iHaveTheMovieId() {
        return response.jsonPath().get("id").toString();
    }


    @When("I change the movie rating to <{string}>")
    public void iChangeTheMovieRatingTo(String rating) {
        String movieId = iHaveTheMovieId();
        body = objectBodyFactory.jsonChangeRatingMovie(rating);
        System.out.println(body);
        movieController.changeMovieId(movieId, body);
    }

}
