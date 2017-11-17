package model.vo;

import model.entity.Mass;

import java.util.List;

public class ActivityVO {
    public int id;
    public String name;
    public String time;
    public String position;
    public List<Mass> masses;
    public String slogan;
    public String remarks;

    public ActivityVO(int id, String name, String time, String position, List<Mass> masses, String slogan, String remarks) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.position = position;
        this.masses = masses;
        this.slogan = slogan;
        this.remarks = remarks;
    }
}
