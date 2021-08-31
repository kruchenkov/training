package domain;

public enum Type {
    SUPPORT("Support"), ESCORT("Escort"), FIGHTER("Fighter"), INTERCEPTOR("Interceptor"), SCOUT("Scout");

    private String name;

    public String getName() {
        return name;
    }

    Type(){}

    Type(String name) {
        this.name = name;
    }
}
