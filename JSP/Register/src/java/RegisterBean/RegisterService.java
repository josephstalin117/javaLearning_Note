/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterBean;

import RegisterBean.CloudDB;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author josephstalin
 */
public class RegisterService {

    public static void main(String[] args) {
        //System.err.println(verifyRepeat("wakaka", "lyz2356002@163.com"));
        //registerDB("yinzhiying", "lyz2356002@gmail.com", "123456");
    }
    /*
     验证输入数据是否合法
     */

    public static boolean dataVerify(String username, String password, String email) {
        boolean isLD = true;

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c <= 'z' && c >= 'a') || (c <= 'Z' && c > 'A') || (c <= '9' && c >= '0'))) {
                isLD = false;
            }
        }

        boolean boo = username.length() > 0 && password.length() > 0 && isLD;
        return boo;
    }

    /*
    -1 指username重复
    -2 指email重复
    */
    public static int verifyRepeat(String username, String email) {
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        int verify = 0;

        String usernameSql = "SELECT id FROM hehe_login WHERE username=?";
        String emailSql = "SELECT id FROM hehe_login WHERE email=?";
        try {
            con = CloudDB.getCon();
            ps = con.prepareStatement(usernameSql);
            ps2 = con.prepareStatement(emailSql);

            ps.setString(1, username);
            ps2.setString(1, email);
            rs = ps.executeQuery();
            rs2 = ps2.executeQuery();
            if (rs.next()) {
                verify = -1;
            }
            if (rs2.next()) {
                verify = -2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloudDB.free(rs, ps, con);
        }
        return verify;
    }

    public static int registerDB(String username, String email, String password) {
        password = RegisterTool.getMD5Str(password);
        int id = CloudDB.writeDb("INSERT INTO hehe_login(username,email,password) VALUES(?,?,?)", new Object[]{username, email, password});
        return id;
    }
}
