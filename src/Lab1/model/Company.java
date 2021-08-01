package Lab1.model;

import java.util.List;

public class Company {

    private Long id;
    private String name;
    private List<Airliner> airliners;
    private List<Cargo> cargos;

    public Company() {}

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airliner> getAirliners() {
        return airliners;
    }

    public void setAirliners(List<Airliner> airliners) {
        this.airliners = airliners;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public void getPlaneCount() {
        int count = 0;
        count += getCargos().size();
        count += getAirliners().size();
        System.out.printf("%nGeneral count of planes is: %d %n", count);
    }

    @Override
    public String toString() {
        return
                ", name='" + name + '\'' +
                ", airliners=" + airliners +
                ", cargos=" + cargos +
                '}';
    }
}
