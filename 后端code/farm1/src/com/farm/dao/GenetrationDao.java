package com.farm.dao;

import com.farm.bean.Genetration;
import com.farm.util.SqlUtil;

import java.util.List;

public class GenetrationDao {
    //查询用户的全部订单状态需要和订单表联系使用
    public List<Genetration> get(int id){
        String sql = "select * from Genetration where userID=?";
        List<Genetration> genetrations = SqlUtil.queryList(Genetration.class, sql, id);
        return genetrations;
    }
    /**
     * //状态表，比较特殊
     * //userID,orderID,orderStatus,buyOrSale
     *
     *     select * from Genetration where userID=?
     *
     *
     *     insert into Genetration(userID,orderID,orderStatus,buyOrSale) values(?,?,?,?)
     *             //一个订单产生，此表则需要插入两个，一个是卖家id和订单号，一个是买家id和订单号
     *
     *     update Genetration set orderStatus=? where userID=? and orderID=?
     *             //更新订单状态
     *
     *     delete from bean.Genetration where userID=? and orderID=?
     *             //订单完成则可删除次状态，但是为了后期可查询，不建议删除
     */
}
