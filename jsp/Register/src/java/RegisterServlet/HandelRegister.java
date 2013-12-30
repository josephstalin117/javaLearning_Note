/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterServlet;

import RegisterBean.Register;
import RegisterBean.RegisterService;
import static RegisterBean.RegisterService.registerDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephstalin
 */
public class HandelRegister extends HttpServlet {
    
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    
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
            out.println("<title>Servlet HandelRegister</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HandelRegister at " + request.getContextPath() + "</h1>");
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        
        Register reg = new Register();//创建JavaBean对象
        request.setAttribute("register", reg); //将dataBean储存到request对象中

        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String email = request.getParameter("email").trim();


        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        if (email == null) {
            email = "";
        }

        boolean dataBoo = RegisterService.dataVerify(username, password, email);
        int usernameBoo = RegisterService.verifyRepeat(username, email);

        String backNews = "";

        if (dataBoo) {
            if (usernameBoo == 0) {
                RegisterService.registerDB(username, email, password);
                reg.setBackNews(backNews);
                reg.setUsername(username);
                reg.setPassword(password);
                reg.setEmail(email);
                backNews = "成功";
            }
            if (usernameBoo == -1) {
                backNews = "username error";
            }
            if (usernameBoo == -2) {
                backNews = "email error";
            }
        } else {
            backNews = "information error";
        }
        reg.setBackNews(backNews);
        RequestDispatcher dispathcher = request.getRequestDispatcher("/Register/show.jsp");
        dispathcher.forward(request, response);
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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

}
