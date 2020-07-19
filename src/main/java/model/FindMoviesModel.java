package model;

import java.util.Date;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
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
}
