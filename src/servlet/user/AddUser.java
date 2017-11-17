package servlet.user;

import db.Dao.UserDao;
import model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String college=new String(req.getParameter("college").getBytes("ISO8859-1"),"UTF-8");
        String clazz=new String(req.getParameter("clazz").getBytes("ISO8859-1"),"UTF-8");

        User user=new User(name,college,clazz);
        UserDao dao=new UserDao();
        dao.insert(user);
    }
}
