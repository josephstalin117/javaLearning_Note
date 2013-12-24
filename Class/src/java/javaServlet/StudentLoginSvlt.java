/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javaBean.CheckEnrol;
import javaBean.SqlBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephstalin
 */
public class StudentLoginSvlt extends HttpServlet {

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
            out.println("<title>Servlet StudentLoginSvlt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentLoginSvlt at " + request.getContextPath() + "</h1>");
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
        String stu_id = req.getParameter("id");

        String cour_id = req.getParameter("cour_id");

        String class_id = req.getParameter("class_id");

        String prepare = req.getParameter("prepare");

        String pw1 = null;

        String pw2 = null;

        String e_mail = null;

        String tel = null;

//获得用户提交来的操作
        String action = req.getParameter("action");

        ResultSet rs = null;

// 更新学生的信息
        if ("update".equalsIgnoreCase(action)) {

            stu_id = req.getParameter("id");

            pw1 = req.getParameter("password1");

            pw2 = req.getParameter("password2");

            if (pw1.equals("") || pw2.equals("") || pw1 == null || pw2 == null) {
                doError(req, res, "密码不能为空！");
            }

            e_mail = req.getParameter("e_mail");

            tel = req.getParameter("tel");

            doUpdate(req, res, pw1, pw2, e_mail, tel, stu_id);

            res.sendRedirect("student.jsp");

        }

// 查看学生的学分
        if ("checkmark".equalsIgnoreCase(action)) {

            rs = getScore(stu_id);

            sendResultSet(req, res, rs, "/checkmark.jsp");

        }

// 选修课程
        if ("enrol".equalsIgnoreCase(action)) {

            doEnrol(req, res, stu_id, cour_id, class_id, prepare);

            res.sendRedirect("student.jsp");
        }

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
     *
     * 选修课程
     *
     */
    public void doEnrol(HttpServletRequest req, HttpServletResponse res,
            String stu_id, String cour_id, String class_id, String prepare)
            throws ServletException, IOException {

        int num = 0;

        CheckEnrol check = new CheckEnrol();

        if (prepare.equals("0")) {

            num = check.enrol(class_id, stu_id);

        }

        if (num == 0) {

            doError(req, res, "注册课程失败！！");

        }

    }

    /**
     *
     * 更新学生的信息
     *
     */
    public void doUpdate(HttpServletRequest req, HttpServletResponse res,
            String pw1, String pw2, String e_mail, String tel, String id)
            throws ServletException, IOException {

        int num = 0;

        if (!pw1.equals(pw2)) {
            doError(req, res, "密码不一致，请重输！");
        }

        CheckEnrol check = new CheckEnrol();

        SqlBean db = new SqlBean();

        num = check.updatestu(pw1, id, e_mail, tel);

        if (num == 0) {
            doError(req, res, "更新失败");
        }

    }

    /**
     *
     * 获得学生的学分
     *
     */
    public ResultSet getScore(String stu_id) {

        String sql = "select enrol.score , course.name ,course.mark "
                + "from enrol ,course ,classes " + "where stu_id='" + stu_id
                + "' " + "and enrol.class_id=classes.id "
                + "and classes.cour_id=course.id ";

        SqlBean db = new SqlBean();

        ResultSet rs = db.executeQuery(sql);

        return rs;

    }

    /**
     *
     * 显示出错明细
     *
     */
    public void doError(HttpServletRequest req, HttpServletResponse res,
            String str) throws ServletException, IOException {

        req.setAttribute("problem", str);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/login.jsp");

        rd.forward(req, res);

    }

    /**
     *
     * 获得学生的学分并显示给用户
     *
     */
    public void sendResultSet(HttpServletRequest req, HttpServletResponse res, java.sql.ResultSet rs, String target) throws ServletException,
            IOException {

        req.setAttribute("rs", rs);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(target);

        rd.forward(req, res);

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
