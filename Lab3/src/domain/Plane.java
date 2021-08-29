package domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Plane {
    private String id;
    private String model;
    private String origin;
    private Set<Chars> chars = new LinkedHashSet<>();
    private Long length;
    private Long width;
    private Long height;
    private Long price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<Chars> getChars() {
        return chars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(getId()).append("\n");
        sb.append("Model: ").append(getModel()).append("\n");
        sb.append("Plane origin: ").append(getOrigin()).append("\n");
        sb.append("Plane chars\n");
        for (Chars chars : getChars()){
            sb.append('\t').append(chars.getName()).append(": ").append(chars.getValue()).append("\n");
        }
        sb.append("Plane length: ").append(getLength()).append("\n");
        sb.append("Plane width: ").append(getWidth()).append("\n");
        sb.append("Plane height").append(getHeight()).append("\n");
        sb.append("Plane price: ").append(getPrice()).append("\n");
        return sb.toString();
    }
}
