package com.springcloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.alibaba.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountDao extends BaseMapper<Account> {
    int decrease(@Param("userId") Long userId,
                 @Param("money") BigDecimal money);
}
