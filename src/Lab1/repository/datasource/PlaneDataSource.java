package Lab1.repository.datasource;

import Lab1.model.Airliner;
import Lab1.model.Cargo;

import java.util.List;

public interface PlaneDataSource {
    List<Airliner> getAirliners();
    List<Cargo> getCargos();

}
