/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileUpload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

/**
 *
 * @author josephstalin
 */
public class FileUploadServlet extends HttpServlet {

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
            out.println("<title>Servlet FileUploadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileUploadServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        request.setCharacterEncoding("UTF-8");

        // 构建上传路径  
        String basePath = getServletContext().getRealPath("/Upload");
        System.out.println("path=" + basePath);

        // 文件上傳部分  
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart == true) {
            try {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                //设置最大文件尺寸
                upload.setFileSizeMax(400000000);

                // 得到所有的表单域，它们目前都被当作FileItem  
                List<FileItem> fileItems = upload.parseRequest(request);
                Iterator<FileItem> iter = fileItems.iterator();

                // 依次处理每个表单域  
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (item.isFormField()) {
                        // 如果item是正常的表单域  
                        String name = item.getFieldName();
                        String value = item.getString();
                        System.out.print("表单域名为:" + name + "表单域值为:" + value);
                    } else {
                        // 如果item是文件上传表单域  
                        // 获得文件名及路径  
                        String fileName = item.getName();
                        System.out.println(fileName);
                        if (fileName != null) {
                            File fullFile = new File(item.getName());
                            // 如果文件存在则上传  
//                            if (fullFile.exists()) {
                            File fileOnServer = new File(basePath, fullFile
                                    .getName());
                            item.write(fileOnServer);

                            System.out.println("文件"
                                    + fileOnServer.getName() + "上传成功");
//                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("the enctype must be multipart/form-data");
        }

        // 取得服务器中已有文件的下載列表  
        List<String> fileListInServer = new ArrayList<String>();

        File dir = new File(basePath);
        String[] children = dir.list();
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                fileListInServer.add(children[i]);
            }
        }
        request.setAttribute("downloadList", fileListInServer);

        // 跳回原頁面  
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/out.jsp");
        dispatcher.forward(request, response);

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
