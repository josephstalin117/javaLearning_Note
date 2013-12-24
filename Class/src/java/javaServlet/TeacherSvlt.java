/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javaBean.Teacher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephstalin
 */
public class TeacherSvlt extends HttpServlet {

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
            out.println("<title>Servlet TeacherSvlt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherSvlt at " + request.getContextPath() + "</h1>");
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
        String tea_id = req.getParameter("id");

        int success = 0;

        String action = action = req.getParameter("action");

        Teacher tea = null;

        String message = "";

//  增加教师
        if ("new".equalsIgnoreCase(action)) {

            tea = doNew(req, res);

            sendBean(req, res, tea, "/getteacher.jsp");

        }

//     更新教师   
        if ("update".equalsIgnoreCase(action)) {

            try {

                tea = doUpdate(req, res, tea_id);

                sendBean(req, res, tea, "/getteacher.jsp");

            } catch (SQLException e) {
            }

        }

//  删除教师                   
        if ("delete".equalsIgnoreCase(action)) {

            try { //删除教师                   

                success = doDelete(tea_id);

            } catch (SQLException e) {
            }

            if (success != 1) {

                doError(req, res, "TeacherSvlt: Delete unsuccessful. Rows affected: " + success);

            } else {

                res.sendRedirect("http://localhost:8084/Class/getteacher.jsp");

            }

        }

    }

    /*

     * 增加新的教师

     *返回类型：teacher

     @param req

     @param res

     @return

     @throws ServletException

     @throws IOException

     */
    public Teacher doNew(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Teacher tea = new Teacher();

        String tea_id = req.getParameter("id");

        String name = new String(req.getParameter("name").getBytes("ISO8859_1"),"UTF-8");

        String password = req.getParameter("password");

        String title = new String(req.getParameter("title").getBytes("ISO8859_1"),"UTF-8");

        //判断教师号已经被注册过；判断录入的是否正确
        if (isTrue(req, res, tea_id, name, password) && hasLogin(req, res, tea_id)) {

            tea.setId(tea_id);

            tea.setName(name);

            tea.setPassword(password);

            tea.setTitle(title);

            tea.addTeacher();

        }

        return tea;

    }

    /*

     * 更新教师信息

     *返回类型：teacher

     @param req

     @param res

     @param id

     @return

     @throws ServletException

     @throws IOException

     @throws SQLException

     */
    public Teacher doUpdate(HttpServletRequest req, HttpServletResponse res, String id)
            throws ServletException, IOException, SQLException {

        Teacher tea = new Teacher();

        String name = new String(req.getParameter("name").getBytes("ISO8859_1"),"UTF-8");

        String password = req.getParameter("password");

        String title = new String(req.getParameter("title").getBytes("ISO8859_1"),"UTF-8");

        if (isTrue(req, res, id, name, password)) {

            tea.setId(id);

            tea.setName(name);

            tea.setPassword(password);

            tea.setTitle(title);

            tea.update();

        }

        return tea;

    }

    /*

     * 删除教师信息

     *返回类型：int

     @param id

     @return

     @throws SQLException

     */
    public int doDelete(String id) throws SQLException {

        int num = 0;

        Teacher tea = new Teacher();

        num = tea.delete(id);

        return num;

    }

    /*

     * 上面的操作成功后，这个方法起到页面跳转作用

     *返回类型：void

     @param req

     @param res

     @param tea

     @param target

     @throws ServletException

     @throws IOException

     */
    public void sendBean(HttpServletRequest req, HttpServletResponse res,
            Teacher tea, String target)
            throws ServletException, IOException {

        req.setAttribute("tea", tea);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(target);

        rd.forward(req, res);

    }

    /*

     * 页面出错时跳转到的页面

     *返回类型：void

     @param req

     @param res

     @param str

     @throws ServletException

     @throws IOException

     */
    public void doError(HttpServletRequest req,
            HttpServletResponse res,
            String str)
            throws ServletException, IOException {

        req.setAttribute("problem", str);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");

        rd.forward(req, res);

    }

    /*

     * 判断教师号已经被注册过

     *返回类型：boolean

     @param req

     @param res

     @param id

     @return

     @throws ServletException

     @throws IOException

     */
    public boolean hasLogin(HttpServletRequest req, HttpServletResponse res, String id)
            throws ServletException, IOException {

        boolean f = true;

        String message = "对不起，该教师号已经被注册过了!";

        Teacher tea = new Teacher();

        f = tea.hasLogin(id);

        if (f == false) {

            doError(req, res, message);

        }

        return f;

    }

    /*

     * 判断录入的是否正确

     *返回类型：boolean

     @param req

     @param res

     @param id

     @param name

     @param password

     @return

     @throws ServletException

     @throws IOException

     */
    public boolean isTrue(HttpServletRequest req, HttpServletResponse res,
            String id, String name, String password)
            throws ServletException, IOException {

        boolean f = true;

        String message = "";

        if (id == null || id.equals("")) {

            f = false;

            message = "错误，教师号不能为空！";

            doError(req, res, message);
        }

        if (name == null || name.equals("")) {

            f = false;

            message = "教师姓名不能为空，请重新填写！";

            doError(req, res, message);
        }

        if (password == null || password.equals("")) {

            f = false;

            message = "密码不能为空，请重新填写！";

            doError(req, res, message);
        }

        return f;

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
