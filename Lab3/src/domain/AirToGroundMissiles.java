package domain;

public class AirToGroundMissiles extends Chars{

    public AirToGroundMissiles(){
        super("Air-to-ground missiles count");
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
