package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.dao.FindMoviesStoreDao;
import domain.dataSource.FindMoviesDataSource;
import domain.impl.FindMoviesStoreImpl;
import enums.FindMoviesDataSourceType;
import enums.Params;
import factory.FindMoviesDataSourceFactory;
import model.FindMoviesModel;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMoviesService {

    FindMoviesDataSourceFactory findMoviesDataSourceFactoryInstance;
    FindMoviesStoreDao findMoviesStoreDao;

    public FindMoviesService() {
        findMoviesDataSourceFactoryInstance = FindMoviesDataSourceFactory.getInstance();
        findMoviesStoreDao = new FindMoviesStoreImpl();
    }

    public String getMovieList(Map<String, String> params) throws Exception {
        Params param = null;
        String value = "name";
        Boolean hasNameParam = false;
        Boolean hasDateParam = false;
        Map<Params, String> paramsMap = new HashMap<>();

        List<FindMoviesModel> findMoviesModelList = null;
        FindMoviesDataSource findMoviesDataSource = null;

        if(params.containsKey("name")) {
            param = Params.NAME;
            hasNameParam = true;
            value = params.get("name");
            paramsMap.put(Params.NAME, params.get("name"));
        }

        if(params.containsKey("date")) {
            param = Params.DATE;
            hasDateParam = true;
            value = params.get("date");
            paramsMap.put(Params.DATE, params.get("date"));
        }

        findMoviesDataSource = findMoviesDataSourceFactoryInstance.getFindMoviesDataSource(FindMoviesDataSourceType.DB);
        findMoviesModelList = findMoviesDataSource.getIMDbMovies(paramsMap);

        if(findMoviesModelList.size() == 0) {
            findMoviesDataSource = findMoviesDataSourceFactoryInstance.getFindMoviesDataSource(FindMoviesDataSourceType.API);
            findMoviesModelList = findMoviesDataSource.getIMDbMovies(paramsMap);
            findMoviesStoreDao.setIMDBMovies(findMoviesModelList);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<FindMoviesModel>>() {}.getType();
        String json = gson.toJson(findMoviesModelList, type);
        return json;
    }
}
