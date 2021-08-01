package Lab1.console;

import Lab1.repository.PlaneRepository;
import Lab1.repository.PlaneRepositoryImpl;
import Lab1.repository.datasource.PlaneDataSource;
import Lab1.repository.datasource.PlaneDataSourceImpl;


public class Main {

    public static void main(String[] args) {
        PlaneDataSource planeDataSource = new PlaneDataSourceImpl();
        PlaneRepository planeRepository = new PlaneRepositoryImpl(planeDataSource);
        Adapter adapter = new Adapter(planeRepository, planeDataSource);
        adapter.menu();

    }
}
