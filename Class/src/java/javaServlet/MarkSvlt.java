/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.Determine;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephstalin
 */
public class MarkSvlt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MarkSvlt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MarkSvlt at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // 获得传入参数

        String tea_id = req.getParameter("id");

        String class_id = null;

        String score = null;

        String stu_id = null;

        String action = action = req.getParameter("action");

        Determine deter = null;

        if ("choosestu".equalsIgnoreCase(action)) {

            // 选择教师要带的学生
            deter = doChoose(tea_id);

            // 上面的操作成功后，这个方法起到页面跳转作用
            sendBean(req, res, deter, "/choosestu.jsp");

        }

        if ("score".equalsIgnoreCase(action)) {

            // 显示学生成绩
            deter = doAccept2(tea_id);

            // 上面的操作成功后，这个方法起到页面跳转作用
            sendBean(req, res, deter, "/score.jsp");

        }

        if ("marking".equalsIgnoreCase(action)) {

            // 得到页面post过来的值
            class_id = req.getParameter("class_id");

            score = req.getParameter("score");

            stu_id = req.getParameter("id");

            // 给所带的学生打分,更新的数据表是enrol
            doMarking(req, res, stu_id, class_id, score);

            // 上面的操作成功后，这个方法起到页面跳转作用
            res.sendRedirect("score.jsp");

        }

        if ("public".equalsIgnoreCase(action)) {

            tea_id = req.getParameter("id");

            // 选择教师要带的学生
            deter = doChoose(tea_id);

            // 上面的操作成功后，这个方法起到页面跳转作用
            sendBean(req, res, deter, "/public.jsp");

        }

        if ("accept".equalsIgnoreCase(action)) {

            // 得到页面post过来的值
            class_id = req.getParameter("class_id");

            // 当教师挑选学生后，显示的下一页面是批准要所带的班级及学生
            deter = doAccept(class_id);

            // 上面的操作成功后，这个方法起到页面跳转作用
            sendBean(req, res, deter, "/displaystu.jsp");

        }

        if ("enrol".equalsIgnoreCase(action)) {

            stu_id = req.getParameter("stu_id");

            class_id = req.getParameter("class_id");

            // 受学生的选课，返回determine对象
            deter = doEnrol(req, res, stu_id, class_id);

            // 上面的操作成功后，这个方法起到页面跳转作用
            sendBean(req, res, deter, "/displaystu.jsp");

        }

    }

    /**
     *
     * 给所带的学生打分,更新的数据表是enrol
     *
     */
    public void doMarking(HttpServletRequest req, HttpServletResponse res,
            String stu_id, String class_id, String score)
            throws ServletException, IOException {

        int num = 0;

        int temp = 0;

        Determine deter = new Determine();

        // 给所带的学生打分
        num = deter.marking(stu_id, class_id, score);

        if (num == 0) {
            doError(req, res, "更新失败！");
        }

        try {

            temp = Integer.parseInt(score);

        } catch (NumberFormatException e) {

            System.out.print(e.toString());

            doError(req, res, "格式不对，请重输！！");

        }

        if (temp >= 60) //当成绩大于60时，则通过
        {
            num = deter.addMark(stu_id, class_id);
        }

        if (num == 0) {
            doError(req, res, "更新失败！");
        }

    }

    /**
     *
     * 接受学生的选课 返回determine对象
     *
     */
    public Determine doEnrol(HttpServletRequest req, HttpServletResponse res,
            String stu_id, String class_id) throws ServletException,
            IOException {

        int num = 0;

        // 定义 determine对象
        Determine deter = new Determine();

        // 接受学生的选课
        num = deter.enrol(stu_id, class_id);

        if (num == 0) {
            doError(req, res, "更新失败！");
        }

        return deter;

    }

    /**
     *
     * 选择教师要带的学生
     *
     */
    public Determine doChoose(String tea_id) {

        Determine deter = new Determine();

        deter.getClass(tea_id);

        return deter;

    }

    /**
     *
     * 显示学生成绩
     *
     */
    public Determine doAccept2(String class_id) {

        Determine deter = new Determine();

        // 显示学生成绩
        deter.getStudents2(class_id);

        return deter;

    }

    /**
     *
     * 当教师挑选学生后，显示的下一页面是批准要所带的班级及学生
     *
     */
    public Determine doAccept(String class_id) {

        Determine deter = new Determine();

        deter.getStudents(class_id);

        return deter;

    }

    /**
     *
     * 起到页面跳转作用
     *
     */
    public void sendBean(HttpServletRequest req, HttpServletResponse res,
            Determine deter, String target) throws ServletException,
            IOException {

        req.setAttribute("deter", deter);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(target);

        rd.forward(req, res);

    }

    /**
     *
     * 页面出错时跳转到的页面
     *
     */
    public void doError(HttpServletRequest req, HttpServletResponse res,
            String str) throws ServletException, IOException {

        req.setAttribute("problem", str);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "teacher.jsp");

        rd.forward(req, res);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
