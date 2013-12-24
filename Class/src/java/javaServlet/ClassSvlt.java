/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javaBean.Classp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephstalin
 */
public class ClassSvlt extends HttpServlet {

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
            out.println("<title>Servlet ClassSvlt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassSvlt at " + request.getContextPath() + "</h1>");
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
        String class_id = req.getParameter("id");

        int success = 0;

        String action = action = req.getParameter("action");

        Classp cla = null;

        String message = "";

//  增加班级信息
        if ("new".equalsIgnoreCase(action)) {

            cla = doNew(req, res);

            sendBean(req, res, cla, "/getClass.jsp");

        }

//   更新班级信息
        if ("update".equalsIgnoreCase(action)) {

            try {

                cla = doUpdate(req, res, class_id);

                sendBean(req, res, cla, "/getClass.jsp");

            } catch (SQLException e) {
            }

        }

//  删除班级信息            
        if ("delete".equalsIgnoreCase(action)) {

            try {               //  删除班级信息

                success = doDelete(class_id);

            } catch (SQLException e) {
            }

            if (success != 1) {

                doError(req, res, "ClassSvlt: Delete unsuccessful. Rows affected: " + success);

            } else {

                res.sendRedirect("http://localhost:8084/Class/getClass.jsp");

            }
        }

    }

    /*

     * 根据传入的参数来增加班级信息

     *返回类型：classp

     @param req

     @param res

     @return

     @throws ServletException

     @throws IOException

     */
    public Classp doNew(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Classp cla = new Classp();

        String class_id = req.getParameter("id");

        String tea_id = req.getParameter("tea_id");

        String cour_id = req.getParameter("cour_id");

        String room_id = req.getParameter("room_id");

        String cour_time = req.getParameter("cour_time");

        //判断录入的是否正确；判断该教师当前时间是否已经安排有课
        if (isTrue(req, res, class_id) && hasMoreclass(tea_id, cour_time, req, res)) {

            cla.setId(class_id);

            cla.setTea_id(tea_id);

            cla.setCour_id(cour_id);

            cla.setRoom_id(room_id);

            cla.setCour_time(cour_time);

            cla.addClass();

        }

        return cla;

    }

    /*

     * 判断该教师当前时间是否已经安排有课

     *返回类型：boolean

     @param tea_id

     @param cour_time

     @param req

     @param res

     @return

     @throws ServletException

     @throws IOException

     */
    public boolean hasMoreclass(String tea_id, String cour_time, HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        boolean f = true;

        String temp = "";

        String message = "";

        Classp cla = new Classp();

        temp = cla.hasMoreclass(tea_id, cour_time);

        if (temp == "no") {
            f = true;
        } else {

            f = false;

            message = "对不起，该教师(" + tea_id + ")在" + cour_time + "时间已经安排有课" + temp + "";

            doError(req, res, message);

        }

        return f;

    }

    /*

     * 判断是否改变

     *返回类型：boolean

     @param tea_id

     @param cour_time

     @param req

     @param res

     @return

     @throws ServletException

     @throws IOException

     */
    public boolean hasChange(String tea_id, String cour_time,
            HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        boolean f = false;

        String tea_id0 = req.getParameter("tea_id0");

        String cour_time0 = req.getParameter("cour_time0");

        if (!tea_id.equals(tea_id0) || !cour_time.equals(cour_time0)) {
            f = true;
        }

        return f;

    }

    /*

     * 更新班级信息

     *返回类型：classp

     @param req

     @param res

     @param id

     @return

     @throws ServletException

     @throws IOException

     @throws SQLException

     */
    public Classp doUpdate(HttpServletRequest req, HttpServletResponse res, String id)
            throws ServletException, IOException, SQLException {

        Classp cla = new Classp();

        String tea_id = req.getParameter("tea_id");

        String cour_id = req.getParameter("cour_id");

        String room_id = req.getParameter("room_id");

        String cour_time = req.getParameter("cour_time");

        if (hasChange(tea_id, cour_time, req, res)) {

            if (hasMoreclass(tea_id, cour_time, req, res)) {

                cla.updateClass(id, tea_id, cour_id, room_id, cour_time);

            }
        } else {

            cla.updateClass(id, cour_id, room_id);

        }

        return cla;

    }

    /*

     * 删除班级信息

     *返回类型：int

     @param id

     @return

     @throws SQLException

     */
    public int doDelete(String id) throws SQLException {

        int num = 0;

        Classp cla = new Classp();

        num = cla.deleteClass(id);

        return num;

    }

    /*

     * 上面的操作成功后，这个方法起到页面跳转作用

     *返回类型：void

     @param req

     @param res

     @param cla

     @param target

     @throws ServletException

     @throws IOException

     */
    public void sendBean(HttpServletRequest req, HttpServletResponse res,
            Classp cla, String target)
            throws ServletException, IOException {

        req.setAttribute("cla", cla);

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

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/myapp/errorpage.jsp");

        rd.forward(req, res);

    }

    /*

     * 判断录入的是否正确

     *返回类型：boolean

     @param req

     @param res

     @param id

     @return

     @throws ServletException

     @throws IOException

     */
    public boolean isTrue(HttpServletRequest req, HttpServletResponse res,
            String id)
            throws ServletException, IOException {

        Classp cla = new Classp();

        boolean f = true;

        String message = "";

        if (id == null || id.equals("")) {

            f = false;

            message = "错误，班级号不能为空！";

            doError(req, res, message);
        }

        if (cla.hasLogin(id)) {

            f = false;

            message = "对不起，班级(" + id + ")已经注册了！";

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
