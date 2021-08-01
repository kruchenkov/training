package Lab1.model;

abstract public class Plane {

    private Long id;
    private String model;
    private String manufacturer;
    private Double lifting;
    private Long maxRangeFlight;
    private Integer fuelBank;

    public Plane() {}

    public Plane(Long id, String model, String manufacturer, Double lifting, Long maxRangeFlight, Integer fuelBank) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.lifting = lifting;
        this.maxRangeFlight = maxRangeFlight;
        this.fuelBank = fuelBank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getLifting() {
        return lifting;
    }

    public void setLifting(Double lifting) {
        this.lifting = lifting;
    }

    public Long getMaxRangeFlight() {
        return maxRangeFlight;
    }

    public void setMaxRangeFlight(Long maxRangeFlight) {
        this.maxRangeFlight = maxRangeFlight;
    }

    public Integer getFuelBank() {
        return fuelBank;
    }

    public void setFuelBank(Integer fuelBank) {
        this.fuelBank = fuelBank;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", lifting=" + lifting +
                ", maxRangeFlight=" + maxRangeFlight +
                ", fuelBank=" + fuelBank +
                '}';
    }
}
