package helpers;

import com.google.gson.Gson;
import models.Movie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class ObjectBodyFactory {

    public String jsonMovie(Map<String,String> movieData){
        String json = new Gson().toJson(movieData);
        return json;
    }

    public String defaultJsonMovie (){
        Movie movie;
        try {
            movie = new Gson().fromJson(new FileReader("src/test/java/testData/createDefaultMovie.json"),
                    Movie.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Gson().toJson(movie);
    }

    public String jsonChangeRatingMovie(String imdbRating){
        String json ="{\n"+ "  \"imdbRating\": \""+imdbRating+"\"\n}";
        return json;
    }
}
