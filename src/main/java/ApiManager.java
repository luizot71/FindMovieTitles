import domain.dao.FindMoviesStoreDao;
import domain.impl.FindMoviesStoreImpl;

public class ApiManager {

    public static void main(String[] args) {
        FindMoviesStoreDao findMoviesStoreDao = new FindMoviesStoreImpl();
    }
}
