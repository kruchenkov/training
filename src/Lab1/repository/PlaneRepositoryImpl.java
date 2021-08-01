package Lab1.repository;

import Lab1.model.Airliner;
import Lab1.model.Cargo;
import Lab1.model.Company;
import Lab1.model.Plane;
import Lab1.repository.datasource.PlaneDataSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaneRepositoryImpl implements PlaneRepository{

    private final PlaneDataSource planeDataSource;

    public PlaneRepositoryImpl(PlaneDataSource planeDataSource) {
        this.planeDataSource = planeDataSource;
    }

    @Override
    public void generalLifting(Company company) {
        Double generalLifting = 0.0;
        /*List<? extends Plane> planes = company.getPlanes();

        Iterator<? extends Plane> iterator = planes.iterator();
        while (iterator.hasNext()){
            Plane plane = iterator.next();
            generalLifting += plane.getLifting();
        }
        System.out.println(generalLifting);*/

        List<Airliner> airliners = company.getAirliners();
        List<Cargo> cargos = company.getCargos();

        Iterator<Airliner> iterator = airliners.iterator();
        while (iterator.hasNext()){
            Airliner plane = iterator.next();
            generalLifting += plane.getLifting();
        }

        Iterator<Cargo> it = cargos.iterator();
        while (it.hasNext()){
            Cargo plane = it.next();
            generalLifting += plane.getLifting();
        }
        System.out.printf("General lifting of a company  %s  is: %.1f kg %n", company.getName(), generalLifting);
    }

    @Override
    public void generalCapacity(Company company) {
        Integer generalCapacity = 0;

        /* List<? extends Plane> planes = company.getPlanes();

       for (int i = 0; i < planes.size(); i++){
           if (planes.get(i) instanceof Airliner){
               generalCapacity += ((Airliner) planes.get(i)).getMaxCapacity();
           }
       }
       System.out.println(generalCapacity);*/

        List<Airliner> airliners = company.getAirliners();
        Iterator<Airliner> iterator = airliners.iterator();
        while (iterator.hasNext()) {
            Airliner plane = iterator.next();
            generalCapacity += plane.getMaxCapacity();
        }
        System.out.printf("General capacity of a company  %s  is: %d places %n", company.getName(), generalCapacity);
    }

    @Override
    public List<Airliner> capacityInput(Company company, int input) {
        List<Airliner> airliners = new ArrayList<>();
        List<Airliner> airliners1 = company.getAirliners();

        for (int i = 0; i < airliners1.size(); i++) {
            if (input <= airliners1.get(i).getMaxCapacity()){
                airliners.add(airliners1.get(i));
            }
        }
        return airliners;
    }

    @Override
    public List<Cargo> liftingInput(Company company, double input) {
        List<Cargo> cargos = new ArrayList<>();
        List<Cargo> cargos1 = company.getCargos();

        for (int i = 0; i < cargos1.size(); i++) {
            if (input <= cargos1.get(i).getLifting()){
                cargos.add(cargos1.get(i));
            }
        }
        return cargos;
    }

    @Override
    public List<? extends Plane> rangeFlightInput(List<? extends Plane> airliners, int input) {
        List<Plane> airliners1 = new ArrayList<>();

        for (int i = 0; i < airliners.size(); i++) {
            if (input <= airliners.get(i).getMaxRangeFlight()){
                airliners1.add(airliners.get(i));
            }
        }
        return airliners1;
    }
}
