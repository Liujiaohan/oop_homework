package model.vo;

import model.entity.User;

import java.util.List;

public class MassVO {
    public int id;
    public String name;
    public String time;
    public String principal;
    public String telephone;
    public String email;
    public List<User> users;
    public String activities;
    public String introduction;

    public MassVO(int id, String name, String time, String principal, String telephone, String email, List<User> users,
                  String activities, String introduction) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.principal = principal;
        this.telephone = telephone;
        this.email = email;
        this.users = users;
        this.activities = activities;
        this.introduction = introduction;
    }
}
