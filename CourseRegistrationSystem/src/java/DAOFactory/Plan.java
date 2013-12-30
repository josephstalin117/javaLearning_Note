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
public class Plan {

    private int pid;
    private int cid;
    private int tid;
    private int location;
    private int capacity;
    private int prepare;
    private int classtime;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrepare() {
        return prepare;
    }

    public void setPrepare(int prepare) {
        this.prepare = prepare;
    }

    public int getClasstime() {
        return classtime;
    }

    public void setClasstime(int classtime) {
        this.classtime = classtime;
    }

    public String toString() {
        return "Plan [pid=" + pid + "cid=" + cid + ", tid=" + tid + ", location" + location + ", capacity=" + capacity + ", prepare="
                + prepare + ", classtime=" + classtime + "]";
    }
}
