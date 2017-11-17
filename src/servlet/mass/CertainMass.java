package servlet.mass;

import db.Dao.MassDao;
import model.entity.Mass;
import model.vo.MassVO;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CertainMass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(req.getParameter("id"));

        MassDao dao=new MassDao();
        MassVO mass=dao.querryById(id);
        String json= JsonUtil.toJson(mass);
        PrintWriter out=resp.getWriter();
        out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
