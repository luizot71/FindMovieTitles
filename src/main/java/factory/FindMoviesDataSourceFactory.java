package factory;

import domain.api.FindMoviesDaoApi;
import domain.dataSource.FindMoviesDataSource;
import domain.impl.FindMoviesStoreImpl;
import enums.FindMoviesDataSourceType;

public class FindMoviesDataSourceFactory {
    private volatile static FindMoviesDataSourceFactory findMoviesDataSourceFactoryInstance = null;
    private void FindMoviesFactory(){}

    FindMoviesDataSource findMoviesDataSource;

    public static FindMoviesDataSourceFactory getInstance() {
        if(findMoviesDataSourceFactoryInstance == null) {
            synchronized (FindMoviesDataSourceFactory.class) {
                if(findMoviesDataSourceFactoryInstance == null) {
                    findMoviesDataSourceFactoryInstance = new FindMoviesDataSourceFactory();
                }
            }
        }
        return findMoviesDataSourceFactoryInstance;
    }

    public FindMoviesDataSource getFindMoviesDataSource(FindMoviesDataSourceType sourceType) {
        switch (sourceType) {
            case DB: {
                findMoviesDataSource = new FindMoviesStoreImpl();
                break;
            }
            case API: findMoviesDataSource = new FindMoviesDaoApi();
        }
        return findMoviesDataSource;
    }
}
