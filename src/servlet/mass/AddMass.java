package servlet.mass;

import db.Dao.MassDao;
import model.entity.Mass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class AddMass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //int id=Integer.parseInt(req.getParameter("id"));
        Enumeration enumeration=req.getParameterNames();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
        String name=new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String time=new String(req.getParameter("time").getBytes("ISO8859-1"),"UTF-8");
        String principal=new String(req.getParameter("principal").getBytes("ISO8859-1"),"UTF-8");
        String telephone=new String(req.getParameter("telephone").getBytes("ISO8859-1"),"UTF-8");
        String email =req.getParameter("email");
        String members=new String(req.getParameter("members").getBytes("ISO8859-1"),"UTF-8");
        String activities=new String(req.getParameter("activities").getBytes("ISO8859-1"),"UTF-8");
        String introduction=new String(req.getParameter("introduction").getBytes("ISO8859-1"),"UTF-8");

        Mass mass=new Mass(name,time,principal,telephone,email,members,activities,introduction);
        MassDao dao=new MassDao();
        dao.insert(mass);
    }
}
