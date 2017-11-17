package model.entity;

public class Activity {
    private int id;
    private String name;
    private String time;
    private String position;
    private String mass;
    private String slogan;
    private String remarks;

    public Activity(int id,String name, String time, String position, String mass, String slogan, String remarks) {
        this.id=id;
        this.name = name;
        this.time = time;
        this.position = position;
        this.mass = mass;
        this.slogan = slogan;
        this.remarks = remarks;
    }

    public Activity(String name, String time, String position, String mass, String slogan, String remarks) {
        this.name = name;
        this.time = time;
        this.position = position;
        this.mass = mass;
        this.slogan = slogan;
        this.remarks = remarks;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
