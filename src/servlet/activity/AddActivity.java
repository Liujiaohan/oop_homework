package servlet.activity;

import db.Dao.ActivityDao;
import model.entity.Activity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddActivity extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String time=new String(req.getParameter("time").getBytes("ISO8859-1"),"UTF-8");
        String position=new String(req.getParameter("position").getBytes("ISO8859-1"),"UTF-8");
        String mass=new String(req.getParameter("mass").getBytes("ISO8859-1"),"UTF-8");
        String slogan=new String(req.getParameter("slogan").getBytes("ISO8859-1"),"UTF-8");
        String remarks=new String(req.getParameter("remarks").getBytes("ISO8859-1"),"UTF-8");

        Activity activity=new Activity(name,time,position,mass,slogan,remarks);
        ActivityDao dao=new ActivityDao();
        dao.insert(activity);

    }
}
