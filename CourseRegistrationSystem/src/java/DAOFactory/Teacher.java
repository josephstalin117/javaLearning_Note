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
public class Teacher {

    private int uuid;
    private int tid;
    private String tname;
    private int sex;
    private Date birthday;
    private int did;
    private int spid;
    private int proid;

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
    public int getTid() {
        return tid;
    }

    /**
     * 设置id
     *
     * @param id
     */
    public void setTid(int tid) {
        this.tid = tid;
    }

    /**
     * 获取用户名
     *
     * @return
     */
    public String getTname() {
        return tname;
    }

    /**
     * 设定用户名
     *
     * @param username
     */
    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }
}
