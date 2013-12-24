/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javaBean.Course;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephstalin
 */
public class CourseSvlt extends HttpServlet {

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
            out.println("<title>Servlet CourseSvlt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseSvlt at " + request.getContextPath() + "</h1>");
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
        String cour_id = req.getParameter("id");

        int success = 0;

        String action = action = req.getParameter("action");

        Course cour = null;

        String message = "";

        //增加课程信息
        if ("new".equalsIgnoreCase(action)) {

            cour = doNew(req, res);

            sendBean(req, res, cour, "/getcourse.jsp");

        }

        //更新课程信息 
        if ("update".equalsIgnoreCase(action)) {

            try {

                cour = doUpdate(req, res, cour_id);

                sendBean(req, res, cour, "/getcourse.jsp");

            } catch (SQLException e) {
            }

        }

//  删除课程信息                   
        if ("delete".equalsIgnoreCase(action)) {

            try {

                success = doDelete(cour_id);

            } catch (SQLException e) {
            }

            if (success != 1) {

                doError(req, res, "CourseSvlt: Delete unsuccessful. Rows affected: " + success);

            } else {

                res.sendRedirect("http://localhost:8084/Class/getcourse.jsp");

            }
        }

    }

    /*

     * 增加课程信息

     *返回类型
     ：course

     @param req

     @param res

     @
     return

     @
     throws ServletException

     @
     throws IOException

     */
    public Course doNew(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Course cour = new Course();

        String cour_id = req.getParameter("id");

        int mark;

        String name = new String(req.getParameter("name").getBytes("ISO8859_1"), "UTF-8");

        try {

            mark = Integer.parseInt(req.getParameter("mark"));

        } catch (NumberFormatException e) {
            mark = 0;
        }

        String dep = new String(req.getParameter("dep").getBytes("ISO8859_1"), "UTF-8");

        String prepare = req.getParameter("prepare");

        // 判断录入的是否正确;该课程号已经被注册过了;判断课程所在系与预修课所在系是否不一致
        if (isTrue(req, res, cour_id, name) && hasLogin(req, res, cour_id) && isCompare(prepare, dep, req, res)) {

            cour.setId(cour_id);

            cour.setName(name);

            cour.setDep(dep);

            cour.setPrepare(prepare);

            cour.setMark(mark);

            cour.addCourse();

        }

        return cour;

    }

    /*

     * 判断课程所在系与预修课所在系是否不一致,在增加新课程进行曲判断

     *返回类型：boolean

     @param prepare

     @param dep

     @param req

     @param res

     @return

     @throws ServletException

     @throws IOException

     */
    public boolean isCompare(String prepare, String dep,
            HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        boolean f = true;

        String tempDep = null;

        String message = null;

        Course cour = new Course();

        if (!prepare.equalsIgnoreCase("0")) {

            tempDep = cour.getPrepareDep(prepare);

            if (tempDep.equals("public")) {
                return true;
            }

            if (dep.equalsIgnoreCase(tempDep)) {
                f = true;
            } else {

                f = false;

                message = "错误，课程所在系与预修课所在系不一致！";

                doError(req, res, message);

            }
        }

        return f;

    }

    /*

     * 更新课程信息

     *返回类型：course

     @param req

     @param res

     @param id

     @return

     @throws ServletException

     @throws IOException

     @throws SQLException

     */
    public Course doUpdate(HttpServletRequest req, HttpServletResponse res, String id)
            throws ServletException, IOException, SQLException {

        Course cour = new Course();

        String name = new String(req.getParameter("name").getBytes("ISO8859_1"), "UTF-8");

        int mark = Integer.parseInt(req.getParameter("mark"));

        String dep = req.getParameter("dep");

        String prepare = req.getParameter("prepare");

        if (isTrue(req, res, id, name) && isCompare(prepare, dep, req, res)) {

            cour.setName(name);

            cour.setMark(mark);

            cour.setDep(dep);

            cour.setPrepare(prepare);

            cour.updateCourse(id);
        }

        return cour;

    }

    /*

     * 删除课程信息

     *返回类型：int

     @param id

     @return

     @throws SQLException

     */
    public int doDelete(String id) throws SQLException {

        int num = 0;

        Course cour = new Course();

        num = cour.deleteCourse(id);

        return num;

    }

    /*

     * 上面的操作成功后，这个方法起到页面跳转作用

     *返回类型：void

     @param req

     @param res

     @param cour

     @param target

     @throws ServletException

     @throws IOException

     */
    public void sendBean(HttpServletRequest req, HttpServletResponse res,
            Course cour, String target)
            throws ServletException, IOException {

        req.setAttribute("cour", cour);

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

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/getcourse.jsp");

        rd.forward(req, res);

    }

    /*

     * 判断课程号已经被注册过

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

        String message = "对不起，该课程号已经被注册过了!";

        Course cour = new Course();

        f = cour.hasLogin(id);

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

     @return

     @throws ServletException

     @throws IOException

     */
    public boolean isTrue(HttpServletRequest req, HttpServletResponse res,
            String id, String name)
            throws ServletException, IOException {

        boolean f = true;

        String message = "";

        if (id == null || id.equals("")) {

            f = false;

            message = "错误，课程号不能为空！";

            doError(req, res, message);
        }

        if (name == null || name.equals("")) {

            f = false;

            message = "课程名不能为空，请重新填写！";

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
