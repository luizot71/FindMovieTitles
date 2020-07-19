package domain.impl;

import domain.dao.FindMoviesStoreDao;
import domain.dataSource.FindMoviesDataSource;
import enums.Params;
import model.FindMoviesModel;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FindMoviesStoreImpl implements FindMoviesStoreDao, FindMoviesDataSource {

    Connection connection = null;

    public FindMoviesStoreImpl() {
        connection = null;
    }

    @Override
    public List<FindMoviesModel> getIMDbMoviesByName(String name) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("");
        List<FindMoviesModel> movies = new ArrayList<>();
        while(resultSet.next()) {
            movies.add(getMovies(resultSet));
        }
        return movies;
    }

    private FindMoviesModel getMovies(ResultSet resultSet) throws Exception {
        FindMoviesModel movies = new FindMoviesModel();
        movies.setId(resultSet.getInt("id"));
        movies.setMovie_title(resultSet.getString("movie_title"));
        movies.setMovie_year(resultSet.getInt("movie_year"));
        movies.setMovie_released(getDateToString(resultSet.getString("movie_released")));
        movies.setMovie_runtime(resultSet.getString("movie_runtime"));
        movies.setMovie_genre(resultSet.getString("movie_genre"));
        movies.setMovie_director(resultSet.getString("movie_director"));
        movies.setMovie_language(resultSet.getString("movie_language"));
        movies.setMovie_country(resultSet.getString("movie_country"));
        movies.setMovie_rating(resultSet.getDouble("movie_rating"));
        movies.setMovieID(resultSet.getString("movieID"));
        movies.setMovie_type(resultSet.getString("movie_type"));
        movies.setMovie_production(resultSet.getString("movie_production"));

        return movies;
    }

    @Override
    public void getIMDbMovies(String name, Integer year) {

    }

    @Override
    public void setIMDBMovies(List<FindMoviesModel> list) throws Exception {

    }

    @Override
    public List<FindMoviesModel> getIMDbMovies(Map<Params, String> list) throws Exception {
        return null;
    }

    private Date getDateToString(String movie_released) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(movie_released);
    }
}
