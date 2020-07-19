package domain.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.dataSource.FindMoviesDataSource;
import enums.Params;
import model.FindMoviesModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FindMoviesDaoApi implements FindMoviesDataSource {

    public List<FindMoviesModel> getIMDbMoviesByName(String name) throws Exception {
        String url = "http://www.omdbapi.com/?i=tt3896198&apikey=fa8f6d4a" + name;
        URL movieUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) movieUrl.openConnection();
        httpURLConnection.setRequestMethod("GET");
        Integer code = httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String input;
        StringBuffer stringBuffer = new StringBuffer();
        while ((input = bufferedReader.readLine()) != null) {
            stringBuffer.append(input);
        }
        bufferedReader.close();
        Gson gson = new GsonBuilder().setDateFormat("yyyyMMdd").create();
        FindMoviesModel findMoviesModel = gson.fromJson(bufferedReader.toString(), FindMoviesModel.class);

        return Arrays.asList(findMoviesModel);
    }

    @Override
    public List<FindMoviesModel> getIMDbMovies(Map<Params, String> paramList) throws Exception {
        List<FindMoviesModel> movieList = null;

        if(paramList.containsKey(Params.NAME) && paramList.size() == 1) {
            movieList = getIMDbMoviesByName(paramList.get(Params.NAME));
        }
        return movieList;
    }
}
