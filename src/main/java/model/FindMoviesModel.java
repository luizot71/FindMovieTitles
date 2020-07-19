package model;

import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class FindMoviesModel {

    @SerializedName("Identifier")
    private Integer id;

    @SerializedName("Movie Title")
    private String movie_title;

    @SerializedName("Movie Year")
    private Integer movie_year;

    @SerializedName("Movie Released")
    private Date movie_released;

    @SerializedName("Runtime Movie")
    private String movie_runtime;

    @SerializedName("Movie Genre")
    private String movie_genre;

    @SerializedName("Movie's director")
    private String movie_director;

    @SerializedName("Movie Language")
    private String movie_language;

    @SerializedName("Movie Country")
    private String movie_country;

    @SerializedName("Movie Rating")
    private Double movie_rating;

    @SerializedName("Movie Identifier")
    private String movieID;

    @SerializedName("Movie Type")
    private String movie_type;

    @SerializedName("Movie production")
    private String movie_production;

    public FindMoviesModel() {
    }

    public FindMoviesModel(Integer id, String movie_title, Integer movie_year, Date movie_released, String movie_runtime, String movie_genre, String movie_director, String movie_language, String movie_country, Double movie_rating, String movieID, String movie_type, String movie_production) {
        this.id = id;
        this.movie_title = movie_title;
        this.movie_year = movie_year;
        this.movie_released = movie_released;
        this.movie_runtime = movie_runtime;
        this.movie_genre = movie_genre;
        this.movie_director = movie_director;
        this.movie_language = movie_language;
        this.movie_country = movie_country;
        this.movie_rating = movie_rating;
        this.movieID = movieID;
        this.movie_type = movie_type;
        this.movie_production = movie_production;
    }

    @Override
    public String toString() {
        return "FindMoviesModel{" +
                "movie_title='" + movie_title + '\'' +
                ", movie_released=" + movie_released +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public Integer getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(Integer movie_year) {
        this.movie_year = movie_year;
    }

    public Date getMovie_released() {
        return movie_released;
    }

    public void setMovie_released(Date movie_released) {
        this.movie_released = movie_released;
    }

    public String getMovie_runtime() {
        return movie_runtime;
    }

    public void setMovie_runtime(String movie_runtime) {
        this.movie_runtime = movie_runtime;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(String movie_language) {
        this.movie_language = movie_language;
    }

    public String getMovie_country() {
        return movie_country;
    }

    public void setMovie_country(String movie_country) {
        this.movie_country = movie_country;
    }

    public Double getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(Double movie_rating) {
        this.movie_rating = movie_rating;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    public String getMovie_production() {
        return movie_production;
    }

    public void setMovie_production(String movie_production) {
        this.movie_production = movie_production;
    }
}
