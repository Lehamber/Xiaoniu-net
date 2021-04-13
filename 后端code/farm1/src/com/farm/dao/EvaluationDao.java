package com.farm.dao;

import com.farm.bean.Evaluation;
import com.farm.bean.Product;
import com.farm.bean.Users;
import com.farm.util.SqlUtil;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * @@
 * //评论不需要修改，直接删除在添加即可，如果需要，可以在加个追加评论功能，不过这样就麻烦了，还要用连表放评论
 */
public class EvaluationDao {
    //显示该产品的评论个数
    public int count(int id){
        String sql="select count(*) count from Evaluation where productID=?";
        Evaluation evaluation = SqlUtil.query(Evaluation.class, sql, id);
        return evaluation.getCount();
    }
    //获取评论内容和时间,评论用户
    public List<Evaluation> get(int productID){
        String sql = "select content,evaluationDate,userID from Evaluation where productID=?";
        List<Evaluation> evaluations = SqlUtil.queryList(Evaluation.class, sql, productID);
        return evaluations;
    }
    //@@插入评论，用户id是该登录的id，产品id是该产品的id
    public boolean add(String content, Data evaluationDate, int userID, int productID){
        String sql = "insert into Evaluation(content,evaluationDate,userID,productID) values(?,?,?,?)";
        return SqlUtil.updateall(sql,content,evaluationDate,userID,productID);
    }
    //用户删除某一产品的评论
    public boolean delete(int productID,int userID){
        String sql = "delete from Evaluation where productID=? and userID=?";
        return SqlUtil.updateall(sql,productID,userID);
    }

}
