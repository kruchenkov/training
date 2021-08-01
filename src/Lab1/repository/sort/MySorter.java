package Lab1.repository.sort;

import Lab1.repository.sort.Sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MySorter<Plane> implements Sorter<Plane> {
    @Override
    public void sort(List<? extends Plane> objects, Comparator<Plane> c) {
        for (int i = 0; i < objects.size() - 1; i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                if (c.compare(objects.get(i), objects.get(j)) > 0){
                    Collections.swap(objects, i, j);
                }
            }
        }
    }
}
