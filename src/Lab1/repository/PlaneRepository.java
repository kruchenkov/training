package Lab1.repository;

import Lab1.model.Airliner;
import Lab1.model.Cargo;
import Lab1.model.Company;
import Lab1.model.Plane;
import Lab1.repository.sort.Sorter;

import java.util.Comparator;
import java.util.List;

public interface PlaneRepository {
    void generalLifting(Company company);

    void generalCapacity(Company company);

    List<Airliner> capacityInput(Company company, int input);

    List<Cargo> liftingInput(Company company, double input);

    List<? extends Plane> rangeFlightInput(List<? extends Plane> airliners, int input);

    static void sort(List<? extends Plane> planes, Sorter<Plane> s, Comparator<Plane> c) {
        s.sort(planes, c);
    }

    static void print(List<? extends Plane> planes) {
        System.out.println("=======================");
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }
}
