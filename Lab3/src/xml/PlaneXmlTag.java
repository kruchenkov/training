package xml;

public enum PlaneXmlTag {
    PLANES("planes"),
    ID("id"),
    PLANE("plane"),
    MODEL("model"),
    ORIGIN("origin"),
    TYPE("type"),
    SITS("sits"),
    CALIBER("caliber"),
    GUN("gun"),
    AIRTOAIRMISSILES("airtoairmissiles"),
    AIRTOGROUNDMISSILES("airtogroundmissiles"),
    RADAR("radar"),
    CHARS("chars"),
    LENGTH("length"),
    WIDTH("width"),
    HEIGHT("height"),
    PARAMETERS("parameters"),
    PRICE("price");

    private String value;

    PlaneXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    }
