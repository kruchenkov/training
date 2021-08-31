package domain;

public class Plane {
    private String id;
    private String model;
    private String origin;
    private Chars chars = new Chars();
    private Parameters parameters = new Parameters();
    private Long price;

    public Plane(){}

    public Plane(String id, String model, String origin, Chars chars, Parameters parameters, Long price) {
        this.id = id;
        this.model = model;
        this.origin = origin;
        this.chars = chars;
        this.parameters = parameters;
        this.price = price;
    }

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

    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nID: ");
        sb.append(id).append("\nModel: ").append(model);
        sb.append("\nOrigin: ").append(origin).append(chars).append(parameters);
        sb.append("\nPrice: ").append(price);
        return sb.toString();
    }

    public class Chars{
        private Type type;
        private Byte sits;
        private String caliber;
        private Byte air_to_air_missiles;
        private Byte air_to_ground_missiles;
        private Boolean radar;

        public Chars(){}

        public Chars(Type type, Byte sits, String caliber, Byte air_to_air_missiles, Byte air_to_ground_missiles, Boolean radar) {
            this.type = type;
            this.sits = sits;
            this.caliber = caliber;
            this.air_to_air_missiles = air_to_air_missiles;
            this.air_to_ground_missiles = air_to_ground_missiles;
            this.radar = radar;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public Byte getSits() {
            return sits;
        }

        public void setSits(Byte sits) {
            this.sits = sits;
        }

        public String getCaliber() {
            return caliber;
        }

        public void setCaliber(String caliber) {
            this.caliber = caliber;
        }

        public Byte getAir_to_air_missiles() {
            return air_to_air_missiles;
        }

        public void setAir_to_air_missiles(Byte air_to_air_missiles) {
            this.air_to_air_missiles = air_to_air_missiles;
        }

        public Byte getAir_to_ground_missiles() {
            return air_to_ground_missiles;
        }

        public void setAir_to_ground_missiles(Byte air_to_ground_missiles) {
            this.air_to_ground_missiles = air_to_ground_missiles;
        }

        public Boolean getRadar() {
            return radar;
        }

        public void setRadar(Boolean radar) {
            this.radar = radar;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nChars:\n\tType:");
            sb.append(type).append("\n\tSits: ").append(sits);
            sb.append("\n\tCaliber of a gun: ").append(caliber);
            sb.append("\n\tAir-to-air missiles: ").append(air_to_air_missiles);
            sb.append("\n\tAir-to-ground missiles: ").append(air_to_ground_missiles);
            sb.append("\n\tRadar: ").append(radar);
            return sb.toString();
        }
    }

    public class Parameters{
        private Long length;
        private Long width;
        private Long height;

        public Parameters(){}

        public Parameters(Long length, Long width, Long height) {
            this.length = length;
            this.width = width;
            this.height = height;
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

        @Override
        public String toString() {
           final StringBuilder sb = new StringBuilder("\nParameters:\n\tLength:");
           sb.append(length).append("\n\tWidth: ").append(width);
           sb.append("\n\tHeight: ").append(height).append('\t');
           return sb.toString();
        }
    }
}
