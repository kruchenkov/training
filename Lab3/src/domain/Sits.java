package domain;

public class Sits extends Chars{
    public Sits() {
        super("Sits count");
    }

    private Integer count;

    @Override
    public void setValue(String value) {
        count = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(count);
    }
}
