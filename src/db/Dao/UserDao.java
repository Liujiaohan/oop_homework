package db.Dao;

import db.DatabaseAccess;
import model.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private DatabaseAccess databaseAccess;

    public UserDao() {
        databaseAccess=DatabaseAccess.getINSTANCE();
    }

    public List<User> querryAll(){
        String sql="SELECT * FROM users;";
        ResultSet resultSet=databaseAccess.query(sql);
        List<User> list=new ArrayList<>();
        try {
            int id;
            String name;
            String college;
            String clazz;
            User user;
            while (resultSet.next()){
                id=resultSet.getInt("id");
                name=resultSet.getString("name");
                college=resultSet.getString("college");
                clazz=resultSet.getString("class");
                user=new User(id,name,college,clazz);
                list.add(user);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public User querryById(int id){
        String sql="SELECT * FROM users WHERE id="+id+";";
        ResultSet resultSet=databaseAccess.query(sql);
        try {
            String name;
            String college;
            String clazz;
            User user;
            if (resultSet.next()){
                id=resultSet.getInt("id");
                name=resultSet.getString("name");
                college=resultSet.getString("college");
                clazz=resultSet.getString("class");
                user=new User(id,name,college,clazz);
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<User> querryByName(String name){
        String sql="SELECT * FROM users WHERE name LIKE '"+name+"';";
        ResultSet resultSet=databaseAccess.query(sql);
        try {
            int id;
            String college;
            String clazz;
            User user;
            List<User> list=new ArrayList<>();
            while (resultSet.next()){
                id=resultSet.getInt("id");
                name=resultSet.getString("name");
                college=resultSet.getString("college");
                clazz=resultSet.getString("class");
                user=new User(id,name,college,clazz);
                list.add(user);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int update(User user){
        String sql="UPDATE users SET name=?,college=?,class=?" +
                "WHERE id=?;";
        Object[] objects=new Object[7];
        objects[0]=user.getName();
        objects[1]=user.getCollege();
        objects[2]=user.getClazz();
        objects[3]=user.getId();

        return databaseAccess.update(sql,objects);
    }


    public int insert(User user){
        String sql="INSERT INTO users (name,college,class)" +
                " VALUES (?,?,?)";
        Object[] objects=new Object[8];
        objects[0]=user.getName();
        objects[1]=user.getCollege();
        objects[2]=user.getClazz();

        return databaseAccess.insert(sql,objects);
    }

    private int deleteById(int id){
        String sql="DELETE FROM users WHERE id="+id+";";
        return databaseAccess.delete(sql);
    }

}
