/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

/**
 *
 * @author josephstalin
 */
public class User {

    private int uuid;
    private String nackname;
    private int role;
    private String email;
    private String password;
    private String picture;
    private String secuquestion;
    private String secuanswer;

    /**
     * 获取全局识别码
     *
     * @return
     */
    public int getUuid() {
        return uuid;
    }

    /**
     * 设定全局识别码
     *
     * @param uuid
     */
    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取昵称
     *
     * @return
     */
    public String getNackname() {
        return nackname;
    }

    /**
     * 设定昵称
     *
     * @param nackname
     */
    public void setNackname(String nackname) {
        this.nackname = nackname;
    }

    /**
     * 获取角色
     *
     * @return
     */
    public int getRole() {
        return role;
    }

    /**
     * 设定角色
     *
     * @param role
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * 获取邮箱
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设定邮箱
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取密码
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设定密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取头像
     *
     * @return
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设定头像
     *
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取安全问题
     *
     * @return
     */
    public String getSecuquestion() {
        return secuquestion;
    }

    /**
     * 设定安全问题
     *
     * @param secuquestion
     */
    public void setSecuquestion(String secuquestion) {
        this.secuquestion = secuquestion;
    }

    /**
     * 获取安全问题答案
     *
     * @return
     */
    public String getSecuanswer() {
        return secuanswer;
    }

    /**
     * 设定安全问题答案
     *
     * @param secuanswer
     */
    public void setSecuanswer(String secuanswer) {
        this.secuanswer = secuanswer;
    }
    /* (non-Javadoc)
     * 重写toString方法
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Student [uuid=" + uuid + ", nackname=" + nackname + ", role=" + role + ", email=" + email + ", password="
                + password + ", picture=" + picture + ", secuquestion=" + secuquestion + ", secuanswer" + secuanswer + "]";
    }
}
