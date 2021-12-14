package entity;

public enum Role {
    ADMIN("Администратор"), CLIENT("Клиент");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
