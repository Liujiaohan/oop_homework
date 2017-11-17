package model.entity;

public class User {
    private int id;
    private String name;
    private String college;
    private String clazz;

    public User(int id, String name, String college, String clazz) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.clazz = clazz;
    }

    public User(String name, String college, String clazz) {
        this.name = name;
        this.college = college;
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
