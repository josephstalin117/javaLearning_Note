package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShowRecordByPage {

    public int getShowPage() {
        return showPage;
    }

    public void setShowPage(int i) {
        if (inOfBounds(i)) {
            showPage = i;
        }
        if (i > pageCount) {
            showPage = pageCount;
        }
        if (i <= 0) {
            showPage = 1;
        }
    }

    public String getPageResult() {
        return scrollPage(showPage);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int i) {
        if (i > 0) {
            pageSize = i;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    //分页
    static int pageSize = 3; // 每页显示多少条记录,默认为3条
    static int pageCount = getPageCountDB();
    static int showPage = 1;

    /**
     * @param page 跳转页面
     */
    static String scrollPage(int page) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from hehe_user limit ?,?";
        String html = "";

        try {
            if (inOfBounds(page)) {
                con = Jdbc.getCon();
                ps = con.prepareStatement(sql);
                ps.setInt(1, (page - 1) * pageSize);
                ps.setInt(2, pageSize);

                rs = ps.executeQuery();

                html = html + "<table border=1>";
                html = html + "<tr><th>id</th><th>name</th><th>birthday</th><th>state</th><th>action</th><th>action</th></tr>";
                while (rs.next()) {
                    html = html + "<tr>";
                    html = html + "<td>" + rs.getInt("id") + "</td>";
                    html = html + "<td>" + rs.getString("username") + "</td>";
                    html = html + "<td>" + rs.getDate("birthday") + "</td>";
                    html = html + "<td>" + rs.getInt("state") + "</td>";
                    html = html + "<td>" + "<a href=updateUser.jsp?action=update&id=" + rs.getInt("id") + ">update</a>" + "</td>";
                    html = html + "<td>" + "<a href=updateUser.jsp?action=delete&id=" + rs.getInt("id") + ">delete</a>" + "</td>";
                    html = html + "</tr>";
                }
                html = html + "</table>";
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.free(rs, ps, con);
        }
        return html;
    }

    /**
     * @param page
     * @return 判断是否出界
     */
    static boolean inOfBounds(int page) {
        if (page <= pageCount && page > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param page 前一页
     */
    static void previousPage(int page) {
        if (inOfBounds(page - 1)) {
            scrollPage(page - 1);
        } else {
            scrollPage(1);
        }
    }

    /**
     * @param page 下一页
     */
    static void nextPage(int page) {
        if (inOfBounds(page + 1)) {
            scrollPage(page + 1);
        } else {
            scrollPage(pageCount);
        }
    }

    /**
     * @return 获得总页数
     */
    public static int getPageCountDB() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) from hehe_user";

        try {
            con = Jdbc.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int size = 0;
            int pageCount = 0;
            if (rs.next()) {
                size = rs.getInt(1);
                if (size % pageSize == 0) {
                    pageCount = size / pageSize;
                } else {
                    pageCount = size / pageSize + 1;
                }
            }
            return pageCount;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.free(rs, ps, con);
        }
        return -1;
    }
}
