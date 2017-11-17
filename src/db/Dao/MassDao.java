package db.Dao;

import db.DatabaseAccess;
import model.entity.Mass;
import model.entity.User;
import model.vo.MassVO;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MassDao {
    private DatabaseAccess databaseAccess;
    private UserDao userDao=new UserDao();
    public MassDao() {
        databaseAccess=DatabaseAccess.getINSTANCE();
    }
    public List<MassVO> querryAll(){
        String sql="SELECT * FROM mass;";
        ResultSet resultSet=databaseAccess.query(sql);
        List<MassVO> list=new ArrayList<>();
        try {
            int id;
            String name;
            String time;
            String principal;
            String telephone;
            String email;
            String members;
            String activities;
            String introduction;
            MassVO mass;
            while (resultSet.next()){
                id=resultSet.getInt("id");
                name=resultSet.getString("name");
                time=resultSet.getString("time");
                principal=resultSet.getString("principal");
                telephone=resultSet.getString("telephone");
                email=resultSet.getString("email");
                activities=resultSet.getString("activities");
                introduction=resultSet.getString("introduction");
                members=resultSet.getString("members");
                String[] memberName=members.split("、");

                List<User> list0=new ArrayList<>();
                for (int i=0;i<memberName.length;i++){
                    List<User> list1=userDao.querryByName(memberName[i]);
                    list0.addAll(list1);
                }
                mass=new MassVO(id,name,time,principal,telephone,email,list0,activities,introduction);
                list.add(mass);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public MassVO querryById(int id){
        String sql="SELECT * FROM mass WHERE id="+id+";";
        ResultSet resultSet=databaseAccess.query(sql);
        try {
            String name;
            String time;
            String principal;
            String telephone;
            String email;
            String members;
            String activities;
            String introduction;
            MassVO mass;
            if (resultSet.next()){
                id=resultSet.getInt("id");
                name=resultSet.getString("name");
                time=resultSet.getString("time");
                principal=resultSet.getString("principal");
                telephone=resultSet.getString("telephone");
                email=resultSet.getString("email");
                members=resultSet.getString("members");
                activities=resultSet.getString("activities");
                introduction=resultSet.getString("introduction");
                String[] memberName=members.split("、");
                List<User> list0=new ArrayList<>();
                for (int i=0;i<memberName.length;i++){
                    List<User> list1=userDao.querryByName(memberName[i]);
                    list0.addAll(list1);
                }
                mass=new MassVO(id,name,time,principal,telephone,email,list0,activities,introduction);
                return mass;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public List<Mass> querryByName(String name){
        String sql="SELECT * FROM mass WHERE name LIKE '"+name+"';";
        ResultSet resultSet=databaseAccess.query(sql);
        try {
            int id;
            String time;
            String principal;
            String telephone;
            String email;
            String members;
            String activities;
            String introduction;
            Mass mass;
            List<Mass> list=new ArrayList<>();
            while (resultSet.next()){
                id=resultSet.getInt("id");
                name=resultSet.getString("name");
                time=resultSet.getString("time");
                principal=resultSet.getString("principal");
                telephone=resultSet.getString("telephone");
                members=resultSet.getString("members");
                email=resultSet.getString("email");
                activities=resultSet.getString("activities");
                introduction=resultSet.getString("introduction");
                mass=new Mass(id,name,time,principal,telephone,email,members,activities,introduction);
                list.add(mass);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int update(Mass mass){
        String sql="UPDATE mass SET name=?,time=?,principal=?,telephone=?,email=?,members=?,activities=?,introduction=?" +
                "WHERE id=?;";
        Object[] objects=new Object[7];
        objects[0]=mass.getName();
        objects[1]=mass.getTime();
        objects[2]=mass.getPrincipal();
        objects[3]=mass.getTelephone();
        objects[4]=mass.getEmail();
        objects[5]=mass.getMembers();
        objects[6]=mass.getActivities();
        objects[7]=mass.getIntroduction();

        return databaseAccess.update(sql,objects);
    }



    public int insert(Mass mass){
        String sql="INSERT INTO mass (name,time,principal,telephone,email,members,activities,introduction)" +
                " VALUES (?,?,?,?,?,?,?,?)";
        Object[] objects=new Object[8];
        objects[0]=mass.getName();
        objects[1]=mass.getTime();
        objects[2]=mass.getPrincipal();
        objects[3]=mass.getTelephone();
        objects[4]=mass.getEmail();
        objects[5]=mass.getMembers();
        objects[6]=mass.getActivities();
        objects[7]=mass.getIntroduction();

        return databaseAccess.insert(sql,objects);
    }

    private int deleteById(int id){
        String sql="DELETE FROM mass WHERE id="+id+";";
        return databaseAccess.delete(sql);
    }

}
