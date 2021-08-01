package Lab1.repository.sort;

import java.util.Comparator;
import java.util.List;

public interface Sorter<Plane> {
    void sort(List<? extends Plane> objects, Comparator<Plane> c);
}
