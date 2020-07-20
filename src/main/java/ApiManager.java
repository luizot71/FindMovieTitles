import domain.dao.FindMoviesStoreDao;
import domain.impl.FindMoviesStoreImpl;
import routes.FindMoviesRoutes;
import service.FindMoviesService;

public class ApiManager {

    public static void main(String[] args) {
        FindMoviesStoreDao findMoviesStoreDao = new FindMoviesStoreImpl();
        FindMoviesService findMoviesService = new FindMoviesService();
        FindMoviesRoutes findMoviesRoutes = new FindMoviesRoutes(findMoviesService);
        findMoviesRoutes.getUserDetails();
        findMoviesRoutes.getMoviesByDate();
        findMoviesRoutes.getMoviesByName();
        findMoviesRoutes.getMoviesByMultipleParams();
    }
}
