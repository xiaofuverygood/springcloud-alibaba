package org.example.springcloud.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/3 12:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    //主键生成策略。
    //如果不设置，会由MybatisPlus根据时间戳和随机数（雪花算法）生成Long主键值，适用于分布式数据库
    //加上此注解，设置为AUTO，表示使用数据库的主键自增
    // @TableId(type = IdType.AUTO)
    private Long id;

    private String serial;
}
