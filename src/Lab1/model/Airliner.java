package Lab1.model;

public class Airliner extends Plane{

    private Integer maxCapacity;

    public Airliner(Long id, String model, String manufacturer, Double lifting, Long maxRangeFlight, Integer fuelBank, Integer maxCapacity){
        super(id, model, manufacturer, lifting, maxRangeFlight, fuelBank);
        this.maxCapacity = maxCapacity;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return
                "Airliner: " +
                "id=" + getId() +
                ", model='" + getModel() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", lifting=" + getLifting() +
                ", maxRangeFlight=" + getMaxRangeFlight() +
                ", fuelBank=" + getFuelBank() +
                ", maxCapacity=" + maxCapacity;
    }
}
