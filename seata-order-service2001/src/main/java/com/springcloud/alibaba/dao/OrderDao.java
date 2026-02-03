package com.springcloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao extends BaseMapper<Order> {
      //新建订单
      void create(Order order);

      //修改订单状态，从0改为1
      void update(@Param("orderId") Long orderId, @Param("status") Integer status);
}
