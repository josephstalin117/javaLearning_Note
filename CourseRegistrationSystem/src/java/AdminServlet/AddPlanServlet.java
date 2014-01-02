/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminServlet;

import DAOFactory.Course;
import DAOFactory.CourseDAO;
import DAOFactory.DAOFactory;
import DAOFactory.Plan;
import DAOFactory.PlanDAO;
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
public class AddPlanServlet extends HttpServlet {

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
            out.println("<title>Servlet AddPlanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddPlanServlet at " + request.getContextPath() + "</h1>");
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

        int pid = Integer.parseInt(request.getParameter("pid").trim());
        int cid = Integer.parseInt(request.getParameter("cid").trim());
        int tid = Integer.parseInt(request.getParameter("tid").trim());
        int location = Integer.parseInt(request.getParameter("location").trim());
        int capacity = Integer.parseInt(request.getParameter("capacity").trim());
        int classtime = Integer.parseInt(request.getParameter("classtime").trim());

        Plan pla = new Plan();

        pla.setPid(pid);
        pla.setCid(cid);
        pla.setTid(tid);
        pla.setLocation(location);
        pla.setCapacity(capacity);
        pla.setClasstime(classtime);

        boolean i = insertPlan(pla);
        if (i) {
            session.setAttribute("state", "成功填加一条课程计划基本信息.");
        } else {
            session.setAttribute("state", "填加课程计划基本信息失败.");
        }

        response.sendRedirect("admin/getPlan.jsp");
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

    private static boolean insertPlan(Plan pla) {
        DAOFactory cloudFactory = DAOFactory.getDAOFactory();

        PlanDAO plaDAO = cloudFactory.getPlanDAO();

        boolean i = plaDAO.insertPlan(pla);

        return i;
    }

}
