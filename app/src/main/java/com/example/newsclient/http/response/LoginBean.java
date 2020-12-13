package com.example.newsclient.http.response;

import java.io.Serializable;

/**
 * desc   : 登录返回
 */
public class LoginBean implements Serializable {


    public LoginBean() {
    }

    /**
     * readerNo : 20200525185317
     * readerName : 张三
     * rSex : 男
     * rPhoneNumber : 1234
     * institute : 软件
     * effectDate : null
     * lostEffectDate : null
     * breakRules :
     * borrowAdd : 0
     * password : 123456
     */

    private String readerNo;
    private String readerName;
    private String rSex;
    private String rPhoneNumber;
    private String institute;
    private Object effectDate;
    private Object lostEffectDate;
    private String breakRules;
    private int borrowAdd;
    private String password;

    public String getReaderNo() {
        return readerNo;
    }

    public void setReaderNo(String readerNo) {
        this.readerNo = readerNo;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getRSex() {
        return rSex;
    }

    public void setRSex(String rSex) {
        this.rSex = rSex;
    }

    public String getRPhoneNumber() {
        return rPhoneNumber;
    }

    public void setRPhoneNumber(String rPhoneNumber) {
        this.rPhoneNumber = rPhoneNumber;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Object getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Object effectDate) {
        this.effectDate = effectDate;
    }

    public Object getLostEffectDate() {
        return lostEffectDate;
    }

    public void setLostEffectDate(Object lostEffectDate) {
        this.lostEffectDate = lostEffectDate;
    }

    public String getBreakRules() {
        return breakRules;
    }

    public void setBreakRules(String breakRules) {
        this.breakRules = breakRules;
    }

    public int getBorrowAdd() {
        return borrowAdd;
    }

    public void setBorrowAdd(int borrowAdd) {
        this.borrowAdd = borrowAdd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}