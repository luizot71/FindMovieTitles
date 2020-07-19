package domain.dao;

import model.FindMoviesModel;

import java.util.List;

public interface FindMoviesStoreDao {
    public List<FindMoviesModel> getIMDbMoviesByName(String name) throws Exception;
    public void getIMDbMovies(String name, Integer year);
    public void setIMDBMovies(List<FindMoviesModel> list) throws Exception;
}
