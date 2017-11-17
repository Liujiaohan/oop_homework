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
import java.util.Comparator;
import java.util.List;

public class MassesInOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        List<MassVO> list=new MassDao().querryAll();
        switch (type){
            case "act":
                sortByActivityCount(list);
                break;
            case "mem":
                sortByMemberCount(list);
                break;
        }
        String json= JsonUtil.toJson(list);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }

    private void sortByMemberCount(List<MassVO> list) {
        list.sort(new Comparator<MassVO>() {
            @Override
            public int compare(MassVO o1, MassVO o2) {
                return o1.users.size()-o2.users.size();
            }
        });
    }

    private void sortByActivityCount(List<MassVO> list){
        list.sort(new Comparator<MassVO>() {
            @Override
            public int compare(MassVO o1, MassVO o2) {
                int activityCount1=o1.activities.split(",").length;
                int activityCount2=o2.activities.split(",").length;
                if (activityCount1>activityCount2) return 1;
                else if (activityCount1<activityCount2) return -1;
                return 0;
            }
        });
    }
}
