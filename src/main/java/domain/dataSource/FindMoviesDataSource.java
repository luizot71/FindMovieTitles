package domain.dataSource;

import enums.Params;
import model.FindMoviesModel;

import java.util.List;
import java.util.Map;

public interface FindMoviesDataSource {

    public List<FindMoviesModel> getIMDbMovies(Map<Params, String> list) throws Exception;
}
