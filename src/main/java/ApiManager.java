import routes.FindMoviesRoutes;
import service.FindMoviesService;

public class ApiManager {

    public static void main(String[] args) {

        FindMoviesService findMoviesService = new FindMoviesService();
        FindMoviesRoutes findMoviesRoutes = new FindMoviesRoutes(findMoviesService);
        findMoviesRoutes.getUserDetails();
        findMoviesRoutes.getMoviesByDate();
        findMoviesRoutes.getMoviesByName();
        findMoviesRoutes.getMoviesByMultipleParams();
    }
}
