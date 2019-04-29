package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface ITravellerDao {
    @Select("SELECT t.* FROM traveller t ,order_traveller ot WHERE ot.travellerId=t.id and ot.orderId=#{ordersId} ")
    public List<Traveller>  findByOrdersId(String ordersId) throws Exception;
}
