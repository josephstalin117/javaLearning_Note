/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javaBean.SqlBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josephstalin
 */
public class login_confirm extends HttpServlet {

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
            out.println("<title>Servlet login_confirm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login_confirm at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = action = request.getParameter("action");

        if ("logout".equalsIgnoreCase(action)) {

            HttpSession session = request.getSession(true);

            session.invalidate();

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/login.jsp");

            rd.forward(request, response);

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = null;

        String id = null;

        id = request.getParameter("id");

        HttpSession session = request.getSession(true);

//把用户ID保存到Session中，这样可以在别的页面中得到当前登录信息
        session.setAttribute("id", String.valueOf(id));

        String password = null;

//获得从页面中提交的信息
        password = request.getParameter("password");

        String kind = null;

        kind = request.getParameter("kind");

//根据当前用户的ID，来得到查询数据库得到密码
        String temp = getPassword(request, response, id, kind);

        if (password.equals(temp)) //当用户的认证通过后，通过此函数来跳转到不同的显示页面
        {
            goo(request, response, kind);
        } else {

            message = "用户名或密码有误！";

//当出错时，把出错信息显示给用户，并跳转到出错页面中去
            doError(request, response, message);

        }

    }

    /**
     *
     * 当用户的认证通过后，通过此函数来跳转到不同的显示页面
     *
     */
    public void goo(HttpServletRequest req, HttpServletResponse res, String kind)
            throws ServletException, IOException {

        if (kind.equals("student")) {//如果是学生登录

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/student.jsp");

            rd.forward(req, res);

        }

        if (kind.equals("teacher")) {//如果是教师登录

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/teacher.jsp");

            rd.forward(req, res);

        }

        if (kind.equals("admin")) {//如果是管理员登录

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/admin.jsp");

            rd.forward(req, res);

        }

    }

    /**
     *
     * 根据当前用户的ID，来得到查询数据库得到密码
     *
     */
    public String getPassword(HttpServletRequest req, HttpServletResponse res, String id, String kind) throws ServletException, IOException {

        SqlBean db = new SqlBean();

        String pw = "";

        String sql = "select password from " + kind + " where id='" + id + "'";

        try {

            ResultSet rs = db.executeQuery(sql);

            if (rs.next()) {

                pw = rs.getString("password");

            }

        } catch (Exception e) {

            System.out.print(e.toString());

        }

        return pw;

    }

    /**
     *
     * 当出错时，把出错信息显示给用户，并跳转到出错页面中去
     *
     */
    public void doError(HttpServletRequest req, HttpServletResponse res,
            String str) throws ServletException, IOException {

        res.sendRedirect("login.jsp");

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
