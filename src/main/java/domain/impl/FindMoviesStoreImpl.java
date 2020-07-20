package domain.impl;

import domain.dao.FindMoviesStoreDao;
import domain.dataSource.FindMoviesDataSource;
import enums.Params;
import model.FindMoviesModel;
import resources.MySqlConnector;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FindMoviesStoreImpl implements FindMoviesStoreDao, FindMoviesDataSource {

    Connection connection = null;

    public FindMoviesStoreImpl() {

        connection = MySqlConnector.getConnection().connection;
    }

    @Override
    public List<FindMoviesModel> getIMDbMoviesByName(String name) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM imdb_api.imdb_movie_store where movie_title like '%\" + name + \"%'");
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
        String query = "";
        String values = "";

        if (list.size() == 1) {
            values += getValuesAsString(list.get(0));
        }else{
            for (FindMoviesModel mvList : list) {
                if (values == "") {
                    values += getValuesAsString(mvList);
                }else{
                    values += ", " + getValuesAsString(mvList);
                }
            }
            query += values + ";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        }
    }

    public String getValuesAsString(FindMoviesModel movies) throws Exception {
        String values = "";
        DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date = (Date)dateFormat.parse(movies.getMovie_released().toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String dtFormat = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);

        values += "('" + movies.getMovie_title() + "'," + movies.getMovie_year() + ",'" + movies.getMovie_runtime() + "','" + movies.getMovie_genre() + "','" +
                movies.getMovie_director() + "','" + movies.getMovie_language() + "','" + movies.getMovie_country() + "'," + movies.getMovie_rating() + ",'" + movies.getMovieID() + "','" +
                movies.getMovie_type() + "','" + movies.getMovie_production() + "')";

        return values;
    }

    @Override
    public List<FindMoviesModel> getIMDbMovies(Map<Params, String> paramList) throws Exception {
        List<FindMoviesModel> movieList = null;

        if (paramList.containsKey(Params.NAME) && paramList.size() == 1) {
            movieList = getIMDbMoviesByName(paramList.get(Params.NAME));
        }
        return movieList;
    }

    private Date getDateToString(String movie_released) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(movie_released);
    }
}
