package model.entity;

public class Mass {
    private int id;
    private String name;
    private String time;
    private String principal;
    private String telephone;
    private String email;
    private String members;
    private String activities;
    private String introduction;

    public Mass(int id, String name, String time, String principal, String telephone, String email, String members,
                String activities, String introduction) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.principal = principal;
        this.telephone = telephone;
        this.email = email;
        this.members = members;
        this.activities = activities;
        this.introduction = introduction;
    }

    public Mass(String name, String time, String principal, String telephone, String email, String members,
                String activities, String introduction) {
        this.name = name;
        this.time = time;
        this.principal = principal;
        this.telephone = telephone;
        this.email = email;
        this.members = members;
        this.activities = activities;
        this.introduction = introduction;
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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
