package domain;

public class AirToAirMissiles extends Chars{

    public AirToAirMissiles(){
        super("Air-to-air missiles count");
    }

    private Byte count;

    @Override
    public void setValue(String value) {
        count = Byte.parseByte(value);
    }

    @Override
    public String getValue() {
        return count.toString();
    }
}
