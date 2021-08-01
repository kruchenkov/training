package Lab1.model;

public class Cargo extends Plane{

    private String cargoType;

    public Cargo (Long id, String model, String manufacturer, Double lifting, Long maxRangeFlight, Integer fuelBank, String cargoType){
        super(id, model, manufacturer, lifting, maxRangeFlight, fuelBank);
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public String toString() {
        return
                "Cargo: " +
                "id=" + getId() +
                ", model='" + getModel() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", lifting=" + getLifting() +
                ", maxRangeFlight=" + getMaxRangeFlight() +
                ", fuelBank=" + getFuelBank() +
                ", cargoType='" + cargoType + '\'';
    }
}
