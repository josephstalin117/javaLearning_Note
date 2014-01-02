/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminServlet;

import DAOFactory.DAOFactory;
import DAOFactory.Student;
import DAOFactory.StudentDAO;
import DAOFactory.User;
import DAOFactory.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josephstalin
 */
public class AddStudentServlet extends HttpServlet {

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
            out.println("<title>Servlet AddStudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddStudentServlet at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession(true);

        int sid = Integer.parseInt(request.getParameter("sid").trim());
        String sname = new String(request.getParameter("sname").trim().getBytes("ISO-8859-1"), "UTF-8");
        int sex = Integer.parseInt(request.getParameter("sex").trim());
        int did = Integer.parseInt(request.getParameter("did").trim());
        int spid = Integer.parseInt(request.getParameter("spid").trim());
        String bir = request.getParameter("birthday").trim();
        String enr = request.getParameter("enrollment").trim();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟 
        java.util.Date brithday = new Date();
        java.util.Date enrollment = new Date();

        try {
            brithday = sdf.parse(bir);
            enrollment = sdf.parse(enr);
        } catch (ParseException ex) {
            Logger.getLogger(AddStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Student stu = new Student();

        stu.setSid(sid);
        stu.setSname(sname);
        stu.setSex(sex);
        stu.setDid(did);
        stu.setSpid(spid);
        stu.setBirthday(brithday);
        stu.setEnrollment(enrollment);

        boolean i = insertStudent(stu);
        if (i) {
            session.setAttribute("state", "成功填加一条学生基本信息.");
        } else {
            session.setAttribute("state", "填加学生基本信息失败.");
        }

        response.sendRedirect("admin/getStudent.jsp");

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
        doGet(request, response);
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

    private static boolean insertStudent(Student stu) {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        UserDAO userDAO = cloudFactory.getUserDAO();
        StudentDAO stuDAO = cloudFactory.getStudentDAO();

        User user = new User();

        user.setRole(1);

        User user2 = userDAO.insertUser(user);

        stu.setUuid(user2.getUuid());

//        Date date=new Date("2008-04-14"); 
//        stu.setBirthday(new java.util.Date());
//        stu.setEnrollment(new java.util.Date());
        boolean i = stuDAO.insertStudent(stu);

        return i;
    }

}
