package servlet.activity;

import db.Dao.ActivityDao;
import model.entity.Activity;
import model.vo.ActivityVO;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public class ActivitiesInOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        List<ActivityVO> list=new ActivityDao().queryAll();
        switch (type){
            case "act":
                sortByMassCount(list);
                break;
            case "time":
                sortByTime(list);
                break;
        }
        String json= JsonUtil.toJson(list);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.println(json);
    }

    private void sortByTime(List<ActivityVO> list) {
        list.sort(new Comparator<ActivityVO>() {
            @Override
            public int compare(ActivityVO o1, ActivityVO o2) {
                String time1=o1.time;
                String time2=o2.time;
                if (time1.compareTo(time2)>0) return 1;
                else if (time1.compareTo(time2)<0) return -1;
                return 0;
            }
        });
    }

    private void sortByMassCount(List<ActivityVO> list){
        list.sort(new Comparator<ActivityVO>() {
            @Override
            public int compare(ActivityVO o1, ActivityVO o2) {
                return o1.masses.size()-o2.masses.size();
            }
        });
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        super.doPost(req, resp);
    }
}
