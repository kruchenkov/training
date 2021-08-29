package domain;

public class isRadar extends Chars{
    public isRadar(){
        super("Have radar");
    }

    private Boolean radar;

    @Override
    public void setValue(String value) {
        radar = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return radar.toString();
    }
}
