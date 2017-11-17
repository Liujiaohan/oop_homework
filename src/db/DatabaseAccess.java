package db;

import javax.sql.DataSource;
import java.io.InputStreamReader;
import java.sql.*;

public class DatabaseAccess {
    //JDBC 驱动名和数据库
    private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/oop";
    // 数据库的凭据
    private static final String user="root";
    private static final String pass="qweasd789";

    private volatile static DatabaseAccess INSTANCE;
    private Connection con;

    private DatabaseAccess(){
        try {
            Class.forName(JDBC_DRIVER);
            con=DriverManager.getConnection(DB_URL,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseAccess getINSTANCE(){
            if (INSTANCE==null){
                synchronized (DatabaseAccess.class){
                    if (INSTANCE==null){
                        INSTANCE=new DatabaseAccess();
                    }
                }
            }
            return INSTANCE;
    }

    public ResultSet query(String sql){
        try{
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            return resultSet;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int update(String sql,Object... args){
        try {
            PreparedStatement statement=con.prepareStatement(sql);
            System.out.println(sql);
            if (args!=null&&args.length>0){
                for (int i=0;i<args.length;i++){
                    statement.setObject(i+1,args[i]);
                    System.out.println(args[i]);
                }
            }
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String sql,Object... args){
        return update(sql,args);
    }

    public int delete(String sql){
        return update(sql,null);
    }

    private void closeAll(Connection con,PreparedStatement statement,ResultSet resultSet){
        if (con!=null){
            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (resultSet!=null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}
