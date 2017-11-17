package db.Dao;

import db.DatabaseAccess;
import model.entity.Activity;
import model.entity.Mass;
import model.vo.ActivityVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.LogUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    private static DatabaseAccess databaseAccess;
    private static final Logger LOG= LoggerFactory.getLogger(ActivityDao.class);
    public ActivityDao() {
        databaseAccess=DatabaseAccess.getINSTANCE();
    }

    public List<ActivityVO> queryAll(){
        String sql="SELECT * FROM activity;";
        List<ActivityVO> list=new ArrayList<>();
        ResultSet resultSet;
        MassDao massDao=new MassDao();
        try {
            ActivityVO activityVO;
            int id;
            String name;
            String time;
            String position;
            String mass;
            String slogan;
            String remarks;
            resultSet=databaseAccess.query(sql);
            while (resultSet.next()){
                id=resultSet.getInt("id");
                name=resultSet.getString("name");
                time=resultSet.getString("time");
                position=resultSet.getString("position");
                mass=resultSet.getString("mass");
                String[] massName=mass.split("、");
                LOG.info("未切分："+mass);
                List<Mass> list0=new ArrayList<>();
                for (int i=0;i<massName.length;i++){
                    List<Mass> list1=massDao.querryByName(massName[i]);
                    LOG.info("切分后："+massName[i]);
                    list0.addAll(list1);
                }
                slogan=resultSet.getString("slogan");
                remarks=resultSet.getString("remarks");
                activityVO =new ActivityVO(id,name,time,position,list0,slogan,remarks);
                list.add(activityVO);
            }
            resultSet.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ActivityVO queryById(int id){
        String sql="SELECT * FROM activityVO WHERE id="+id+";";
        ActivityVO activityVO;
        ResultSet resultSet;
        MassDao massDao=new MassDao();
        try {
            String name;
            String time;
            String positon;
            String mass;
            String slogan;
            String remarks;
            resultSet=databaseAccess.query(sql);
            if (resultSet.next()){
                name=resultSet.getString("name");
                time=resultSet.getString("time");
                positon=resultSet.getString("position");
                mass=resultSet.getString("mass");
                String[] massName=mass.split("、");
                List<Mass> list0=new ArrayList<>();
                for (int i=0;i<massName.length;i++){
                    List<Mass> list1=massDao.querryByName(massName[i]);
                    list0.addAll(list1);
                }
                slogan=resultSet.getString("slogan");
                remarks=resultSet.getString("remarks");
                activityVO =new ActivityVO(id,name,time,positon,list0,slogan,remarks);
                return activityVO;
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int update(Activity activity){
        String sql="UPDATE activityVO SET name=?,time=?,position=?,mass=?,slogan=?,remarks=?," +
                "WHERE id=?;";
        Object[] objects=new Object[7];
        objects[0]= activity.getName();
        objects[1]= activity.getTime();
        objects[2]= activity.getPosition();
        objects[3]= activity.getMass();
        objects[4]= activity.getSlogan();
        objects[5]= activity.getRemarks();
        objects[6]= activity.getId();
        return databaseAccess.update(sql,objects);
    }


    public int insert(Activity activity){
        String sql="INSERT INTO activityVO (name,time,position,mass,slogan,remarks) VALUES (?,?,?,?,?,?)";
        Object[] objects=new Object[7];
        objects[0]= activity.getName();
        objects[1]= activity.getTime();
        objects[2]= activity.getPosition();
        objects[3]= activity.getMass();
        objects[4]= activity.getSlogan();
        objects[5]= activity.getRemarks();
        return databaseAccess.insert(sql,objects);
    }

    private int deleteById(int id){
        String sql="DELETE FROM activity WHERE id="+id+";";
        return databaseAccess.delete(sql);
    }
}
