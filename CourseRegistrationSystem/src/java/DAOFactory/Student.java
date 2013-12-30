/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import java.util.Date;

/**
 *
 * @author josephstalin
 */
public class Student {

    private int uuid;
    private int sid;
    private String sname;
    private int sex;
    private int did;
    private int spid;
    private Date birthday;
    private Date enrollment;

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
     */
    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取id
     *
     * @return
     */
    public int getSid() {
        return sid;
    }

    /**
     * 设置id
     *
     * @param sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * 获取用户名
     *
     * @return
     */
    public String getSname() {
        return sname;
    }

    /**
     * 设定用户名
     *
     * @param username
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    /**
     * 获取生日
     *
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设定生日
     *
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取入学时间
     *
     * @return
     */
    public Date getEnrollment() {
        return enrollment;
    }

    /**
     * 设定入学时间
     *
     * @param state
     */
    public void setEnrollment(Date enrollment) {
        this.enrollment = enrollment;
    }

    /* (non-Javadoc)
     * 重写toString方法
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Student [uuid=" + uuid + ", sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", did=" + did + ", spid=" + spid + ", birthday="
                + birthday + ", enrollment=" + enrollment + "]";
    }

}
