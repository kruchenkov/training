package Lab1.domain;

public class Plane {

    private Long id;
    private String model;
    private String manufacturer;
    private Double capacity;
    private Double lifting;
    private PlaneType planeType;
    private Long rangeFlight;
    private Integer fuelBank;

    public Plane() {}

    public Plane(Long id, String model, String manufacturer, Double capacity, Double lifting, PlaneType planeType, Long rangeFlight, Integer fuelBank) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.lifting = lifting;
        this.planeType = planeType;
        this.rangeFlight = rangeFlight;
        this.fuelBank = fuelBank;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Double getCapacity() {
        return capacity;
    }

    public Double getLifting() {
        return lifting;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public Long getRangeFlight() {
        return rangeFlight;
    }

    public Integer getFuelBank() {
        return fuelBank;
    }
}
