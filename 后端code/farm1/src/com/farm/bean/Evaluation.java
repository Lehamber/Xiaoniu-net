package com.farm.bean;


import java.util.Date;

public class Evaluation {
    private int evaluationID;//评论id
    private String content;//评论内容
    private Date evaluationDate;//评论日期
    private int userID;//用户id，注意类型
    private int productID;//产品id，注意类型
    private int count;

    @Override
    public String toString() {
        return "Evaluation{" +
                "evaluationID=" + evaluationID +
                ", content='" + content + '\'' +
                ", evaluationDate=" + evaluationDate +
                ", userID=" + userID +
                ", productID=" + productID +
                '}';
    }

    public Evaluation(int evaluationID, String content, Date evaluationDate, int userID, int productID) {
        this.evaluationID = evaluationID;
        this.content = content;
        this.evaluationDate = evaluationDate;
        this.userID = userID;
        this.productID = productID;
    }

    public Evaluation() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(int evaluationID) {
        this.evaluationID = evaluationID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
