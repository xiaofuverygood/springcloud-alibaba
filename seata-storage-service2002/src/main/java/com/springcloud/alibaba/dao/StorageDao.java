package com.springcloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.alibaba.domain.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageDao extends BaseMapper<Storage> {
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
