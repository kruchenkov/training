package Lab1.repository.datasource;

import Lab1.model.Airliner;
import Lab1.model.Cargo;
import Lab1.model.Company;
import Lab1.repository.PlaneRepository;
import Lab1.repository.PlaneRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class PlaneDataSourceImpl implements PlaneDataSource {

    public static Company getAirCraft() {
        return airCraft;
    }

    private static Company airCraft = new Company(1L, "AirCraft");
    private List<Airliner> airCraftAirliners = new ArrayList<>();
    private List<Cargo> airCraftCargos = new ArrayList<>();

    public PlaneDataSourceImpl() {
        initData();
    }

    private void initData() {


        Cargo cargo1 = new Cargo(1L, "Boeing 737", "Boeing", 15000.0, 7000L, 25800, "Medicine");
        Cargo cargo2 = new Cargo(2L, "AH 12", "Antonov", 20000.0, 2000L, 5100, "Medicine");
        Cargo cargo3 = new Cargo(3L, "L 100-30", "Let", 23000.0, 2500L, 7100, "Ammo");
        Cargo cargo4 = new Cargo(4L, "Boeing 757", "Boeing", 39000.0, 6400L, 43000, "Ammo");
        Cargo cargo5 = new Cargo(5L, "Airbus 300 B4", "Airbus", 43500.0, 2700L, 8100, "Technic");
        Airliner airliner1 = new Airliner(1L, "Airbus A320", "Airbus", 16600.0, 6100L, 27000, 180);
        Airliner airliner2 = new Airliner(2L, "Fokker F27", "Fokker", 10890.0, 3470L, 13360, 79);
        Airliner airliner3 = new Airliner(3L, "Let L-410", "Let", 1710.0, 1540L, 1675, 19);
        Airliner airliner4 = new Airliner(4L, "Douglas DC-9", "Douglas", 15400.0, 3470L, 16100, 139);
        Airliner airliner5 = new Airliner(4L, "Airbus A330-300", "Airbus", 51700.0, 10400L, 97530, 440);

        airCraftCargos.add(cargo1);
        airCraftCargos.add(cargo2);
        airCraftCargos.add(cargo3);
        airCraftCargos.add(cargo4);
        airCraftCargos.add(cargo5);

        airCraftAirliners.add(airliner1);
        airCraftAirliners.add(airliner2);
        airCraftAirliners.add(airliner3);
        airCraftAirliners.add(airliner4);
        airCraftAirliners.add(airliner5);

        airCraft.setAirliners(airCraftAirliners);
        airCraft.setCargos(airCraftCargos);
    }

    @Override
    public List<Airliner> getAirliners() {
        return airCraftAirliners;
    }

    @Override
    public List<Cargo> getCargos() {
        return airCraftCargos;
    }
}
