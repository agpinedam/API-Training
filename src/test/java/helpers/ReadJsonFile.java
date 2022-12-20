package helpers;

import com.google.gson.Gson;
import models.Movie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile {

    public String readCreateDefaultMovie(){
        Gson gson = new Gson();
        Movie movie;
        try {
            movie = gson.fromJson(new FileReader("src/test/java/testData/createDefaultMovie.json"),
                    Movie.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Gson().toJson(movie);
    }
}
