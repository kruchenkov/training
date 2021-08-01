package Lab1.repository.sort;

import Lab1.model.Airliner;
import Lab1.model.Plane;

import java.util.Comparator;

public class FuelComparator implements Comparator<Plane> {
    @Override
    public int compare(Plane p1, Plane p2) {
        return p1.getFuelBank().compareTo(p2.getFuelBank());
    }
}
