package routes;

import spark.Request;
import spark.Response;
import spark.Route;
import service.FindMoviesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class FindMoviesRoutes {

    private FindMoviesService findMoviesService;

    public FindMoviesRoutes(FindMoviesService findMoviesService) {
        this.findMoviesService = findMoviesService;
    }

    public void getUserDetails() {
        get(new Route("/users/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return "User: username= hi, email= hi@hi.net";
            }
        });
    }

    public void getMoviesByDate() {
        get(new Route("/getMovies/date/:date") {

            @Override
            public Object handle(Request request, Response response) throws Exception {
                String date = request.params("date");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date dt = null;

                try {
                    dt = dateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return "Date:" + dt;
            }
        });
    }

    public void getMoviesByName() {
        get(new Route("/getMovies/name/:name") {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String name = request.params(":name");

                return "Movie name: " + name;
            }
        });
    }

    public void getMoviesByMultipleParams() {
        get(new Route("/getMovies") {

            @Override
            public Object handle(Request request, Response response) throws Exception {
                Map<String, String> paramsMap = new HashMap<>();
                for(String param : request.queryParams()) {
                    paramsMap.put(param, request.queryParams(param));
                }
                String movies = null;
                try {
                    movies = findMoviesService.getMovieList(paramsMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return movies;
            }
        });
    }
}
