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
public class Course {

    private int cid;
    private String cname;
    private String cintroduction;
    private int credit;
    private int period;
    private int limit;
    private int cgestbook;
    private int mark;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCintroduction() {
        return cintroduction;
    }

    public void setCintroduction(String cintroduction) {
        this.cintroduction = cintroduction;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCgestbook() {
        return cgestbook;
    }

    public void setCgestbook(int cgestbook) {
        this.cgestbook = cgestbook;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student [cid=" + cid + ", cname=" + cname + ", cintroduction=" + cintroduction + ", credit=" + credit + ", period="
                + period + ", limit=" + limit + ", cgestbook=" + cgestbook + ", mark" + mark + "]";
    }

}
