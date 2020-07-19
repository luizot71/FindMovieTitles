package model;

import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class FindMoviesModel {
    @SerializedName("ID")
    private Integer id;

    private String title;

    private Integer year;

    private Date released;

    private String runtime;

    private String genre;

    private String director;

    private String language;

    private String country;

    private Double rating;

    private String movieID;

    private String type;

    private String production;

    public FindMoviesModel() {
    }

    public FindMoviesModel(Integer id, String title, Integer year, Date released, String runtime, String genre, String director, String language, String country, Double rating, String movieID, String type, String production) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.language = language;
        this.country = country;
        this.rating = rating;
        this.movieID = movieID;
        this.type = type;
        this.production = production;
    }

    @Override
    public String toString() {
        return "SeeMovieModel{" +
                "title='" + title + '\'' +
                ", released=" + released +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
