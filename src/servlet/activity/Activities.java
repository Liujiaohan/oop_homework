package servlet.activity;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Dao.ActivityDao;

import model.vo.ActivityVO;

import util.JsonUtil;

public class Activities extends HttpServlet {
    public static ServletContext servletContext;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        servletContext=getServletContext();
        ActivityDao      activityDao = new ActivityDao();
        List<ActivityVO> list        = activityDao.queryAll();
        String           json        = JsonUtil.toJson(list);
        PrintWriter      out         = resp.getWriter();

        out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
