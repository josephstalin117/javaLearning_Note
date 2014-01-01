/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CloudServlet;

import DAOFactory.Admin;
import DAOFactory.AdminDAO;
import DAOFactory.CloudUserDAO;
import DAOFactory.DAOFactory;
import DAOFactory.Student;
import DAOFactory.StudentDAO;
import DAOFactory.Teacher;
import DAOFactory.TeacherDAO;
import DAOFactory.User;
import DAOFactory.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josephstalin
 */
public class LoginServlet extends HttpServlet {

    static int Uuid;

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        response.setCharacterEncoding("UTF-8");

        //实例化登录Bean
        LoginBean loginBean = new LoginBean();
        String backNews = "";
        HttpSession session = request.getSession(true);

        //验证session
        loginBean = (LoginBean) session.getAttribute("login");

        if (loginBean == null) {
            loginBean = new LoginBean();
            session.setAttribute("login", loginBean);
        }

        //接收前端表单数据
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String role = request.getParameter("role").trim();

        boolean ok = loginBean.getSuccess();

        if (ok == true && username.equals(loginBean.getUsername())) {
            backNews = username + "已登录";
            loginBean.setBackNews(backNews);
            response.sendRedirect(redirectLink(loginBean));
        } else {

            loginBean.setUsername(username);
            loginBean.setPassword(password);
            loginBean.setRole(role);

            int v = verifyRole(loginBean);

            if (v == 1) {
                loginBean.setBackNews("success");
                loginBean.setSuccess(true);
                loginBean.setUuid(Uuid);
                session.setAttribute("login", loginBean);
                response.sendRedirect(redirectLink(loginBean));
            } else {
                loginBean.setBackNews("fail");
                session.setAttribute("error", loginBean.getBackNews());
                response.sendRedirect(redirectLink(loginBean));
            }

        }

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

    /**
     *
     * @param role
     * @param username
     * @param password
     * @return -1 no legal enter 1 success 0 account no found 2 password error
     */
    public int verifyRole(LoginBean login) {

        //Global Variables
        int uuid = -1;

        int role = Integer.parseInt(login.getRole());
        int username = Integer.parseInt(login.getUsername());
        String password = login.getPassword();

        int result = -1;

        //启动Cloud内核
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        //student
        if (role == 1) {
            StudentDAO stuDAO = cloudFactory.getStudentDAO();

            Student stu = stuDAO.loginStudent(username);

            if (stu == null) {
                result = 0;
            } else {
                uuid = stu.getUuid();
                int i = verifyPassword(uuid, password);
                if (i == 1) {
                    result = 1;
                } else {
                    result = 2;
                }
            }

        }

        //teacher
        if (role == 2) {
            TeacherDAO teaDAO = cloudFactory.getTeacherDAO();

            Teacher tea = teaDAO.loginTeacher(username);

            if (tea == null) {
                result = 0;
            } else {
                uuid = tea.getUuid();

                int i = verifyPassword(uuid, password);
                if (i == 1) {
                    result = 1;
                } else {
                    result = 2;
                }
            }

        }

        //admin
        if (role == 3) {
            AdminDAO admDAO = cloudFactory.getAdminDAO();

            Admin adm = admDAO.findAdmin(username);

            if (adm == null) {
                result = 0;
            } else {
                uuid = adm.getUuid();
                int i = verifyPassword(uuid, password);
                if (i == 1) {
                    result = 1;
                } else {
                    result = 2;
                }
            }

        }
        if (result == 1) {
            Uuid = uuid;
        }
        return result;
    }

    public int verifyPassword(int uuid, String password) {

        int i = -1;

        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        UserDAO useDAO = cloudFactory.getUserDAO();

        User use = useDAO.findUser(uuid);

        String pwd = use.getPassword();

        String testPassword = CloudUserDAO.getMD5(password);

        if (pwd.equals(CloudUserDAO.getMD5(password))) {
            i = 1;
        } else {
            i = 0;
        }

        return i;
    }

    public String redirectLink(LoginBean login) {
        String role = login.getRole();
        String redirect = "index.jsp";

        if (login.getSuccess()) {
            if (role.equals("1")) {
                redirect = "student/student.jsp";
            }
            if (role.equals("2")) {
                redirect = "teacher/teacher.jsp";
            }
            if (role.equals("3")) {
                redirect = "admin/admin.jsp";
            }
        }
        return redirect;
    }

}
