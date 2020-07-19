package domain.api;

import domain.dataSource.FindMoviesDataSource;
import enums.Params;
import model.FindMoviesModel;

import java.util.List;
import java.util.Map;

public class FindMoviesDaoApi implements FindMoviesDataSource {

    @Override
    public List<FindMoviesModel> getIMDbMovies(Map<Params, String> list) throws Exception {
        return null;
    }
}
