package xml;

import domain.Plane;
import simpleValidate.PlaneXmlValidator;

import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        PlaneXmlValidator validator = new PlaneXmlValidator();

        try{

            if (validator.validate()) {
                PlaneSaxBuilder saxBuilder = new PlaneSaxBuilder();
                saxBuilder.buildSetPlanes(System.getProperty("user.dir") + "/Lab3/planes.xml");
                List<Plane> planes = new ArrayList<>(saxBuilder.getPlanes());
                planes.sort(Comparator.comparing(Plane::getPrice));

                for (Plane plane : planes) {
                    System.out.println(plane);
                }

            } else {
                System.out.println(validator.getError());
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
