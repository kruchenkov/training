package Lab1.console;

import Lab1.model.Plane;
import Lab1.repository.PlaneRepository;
import Lab1.repository.datasource.PlaneDataSource;
import Lab1.repository.datasource.PlaneDataSourceImpl;
import Lab1.repository.sort.FuelComparator;
import Lab1.repository.sort.LiftingComparator;
import Lab1.repository.sort.MySorter;
import Lab1.repository.sort.RangeComparator;

import java.util.Scanner;

public class Adapter {
    private final PlaneRepository planeRepository;
    private final PlaneDataSource planeDataSource;

    public Adapter(PlaneRepository planeRepository, PlaneDataSource planeDataSource) {
        this.planeRepository = planeRepository;
        this.planeDataSource = planeDataSource;
    }

    public void subMenu1() {
        int x = 0;
        String s = "";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("________________________________");
            System.out.println("1. Get general lifting");
            System.out.println("2. Get general capacity");
            System.out.println("3. Get general count of planes");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            s = scanner.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }

            switch (x) {
                case 1:
                    planeRepository.generalLifting(PlaneDataSourceImpl.getAirCraft());
                    break;
                case 2:
                    planeRepository.generalCapacity(PlaneDataSourceImpl.getAirCraft());
                    break;
                case 3:
                    PlaneDataSourceImpl.getAirCraft().getPlaneCount();
                    break;
                case 4:
                    break;
                }
            } while (!"4".equals(s));
    }

    public void subMenu2() {
        int x = 0;
        String s = "";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("________________________________");
            System.out.println("1. Sort aircraft by range flight");
            System.out.println("2. Sort aircraft by lifting");
            System.out.println("3. Sort aircraft by fuel bank");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            s = scanner.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }

            switch (x) {
                case 1:
                    PlaneRepository.sort(planeDataSource.getAirliners(), new MySorter<Plane>(), new RangeComparator());
                    PlaneRepository.sort(planeDataSource.getCargos(), new MySorter<Plane>(), new RangeComparator());
                    PlaneRepository.print(planeDataSource.getAirliners());
                    PlaneRepository.print(planeDataSource.getCargos());
                    break;
                case 2:
                    PlaneRepository.sort(planeDataSource.getAirliners(), new MySorter<Plane>(), new LiftingComparator());
                    PlaneRepository.sort(planeDataSource.getCargos(), new MySorter<Plane>(), new LiftingComparator());
                    PlaneRepository.print(planeDataSource.getAirliners());
                    PlaneRepository.print(planeDataSource.getCargos());
                    break;
                case 3:
                    PlaneRepository.sort(planeDataSource.getAirliners(), new MySorter<Plane>(), new FuelComparator());
                    PlaneRepository.sort(planeDataSource.getCargos(), new MySorter<Plane>(), new FuelComparator());
                    PlaneRepository.print(planeDataSource.getAirliners());
                    PlaneRepository.print(planeDataSource.getCargos());
                    break;
                case 4:
                    break;
            }
        } while (!"4".equals(s));
    }

    public void subMenu3() {
        int x = 0;
        int y = 0;
        double z = 0;
        String s = "";
        Scanner scanner = new Scanner(System.in);


        try {
            x = Integer.parseInt(s);
            y = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }


            System.out.println("Choose type of aircraft");
            System.out.println("1. Airliner");
            System.out.println("2. Cargo");
            s = scanner.next();

            if (s.equals("1")){
                System.out.print("Input the required number of passenger seats: ");
                x = scanner.nextInt();
                PlaneRepository.print(planeRepository.capacityInput(PlaneDataSourceImpl.getAirCraft(), x));
                System.out.print("Input the required distance: ");
                y = scanner.nextInt();
                PlaneRepository.print(planeRepository.rangeFlightInput(planeRepository.capacityInput(PlaneDataSourceImpl.getAirCraft(), x), y));
            }

            if (s.equals("2")){
                System.out.print("Input the required lifting: ");
                z = scanner.nextDouble();
                PlaneRepository.print(planeRepository.liftingInput(PlaneDataSourceImpl.getAirCraft(), z));
                System.out.print("Input the required distance: ");
                y = scanner.nextInt();
                PlaneRepository.print(planeRepository.rangeFlightInput(planeRepository.liftingInput(PlaneDataSourceImpl.getAirCraft(), z), y));
            }

    }

    public void menu() {
        int x = 0;
        String s = "";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("________________________________");
            System.out.println("1. View the list of aircraft.");
            System.out.println("2. View general");
            System.out.println("3. Find plane");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            s = scanner.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }

            switch (x) {
                case 1:
                    PlaneRepository.print(planeDataSource.getAirliners());
                    PlaneRepository.print(planeDataSource.getCargos());
                    subMenu2();
                    break;
                case 2:
                    subMenu1();
                    break;
                case 3:
                    subMenu3();
                    break;
                case 4:
                    break;
            }
        } while (!"4".equals(s));
    }
}
