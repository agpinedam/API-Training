package models;

import com.google.gson.Gson;

import java.util.Map;

public class Movie {
    private String title;
    private String year;
    private String runtime;
    private String director;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String id;


    public Movie(String title, String year, String runtime, String director,
                 String actors, String plot, String language, String country,
                 String awarads, String metascore, String imdbRating, String imdbVotes,
                 String id) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awarads;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.id = id;
    }

    public Movie(String title, String year, String runtime, String director,
                 String actors, String plot, String language, String country,
                 String awarads, String metascore, String imdbRating, String imdbVotes) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awarads;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
    }


    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRuntime() {
        return runtime;
    }


    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getId() {
        return id;
    }
}
