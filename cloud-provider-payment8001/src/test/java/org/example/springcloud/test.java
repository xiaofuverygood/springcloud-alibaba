package org.example.springcloud;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.example.springcloud.dao.PaymentMapper;
import org.example.springcloud.pojo.entity.Payment;
import org.example.springcloud.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.List;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/3/3 13:01
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testSelectOne(){
        //1. 根据主键查询一个数据
        /*Payment payment = paymentMapper.selectById(31);
        System.out.println("数据:" + payment.toString());*/
        List<Payment> atguigu002s = paymentService.list(
                Wrappers.<Payment>lambdaQuery().eq(Payment::getSerial, "atguigu002"));
        atguigu002s.stream().forEach(System.out::println);

        // IPage<Payment> atguigu002 = paymentService.page(new Page<>(1, 2), Wrappers.<Payment>lambdaQuery().eq(Payment::getSerial, "atguigu002"));
        // IPage<Payment> atguigu0021 = paymentMapper.selectPage(new Page<>(1, 1), new LambdaQueryWrapper<>());
        // System.out.println(atguigu0021.getPages());
        // atguigu002.getRecords().stream().forEach(System.out::println);

        QueryWrapper<Payment> wrapper = new QueryWrapper<>();
        wrapper.eq("serial", "atguigu002");

        IPage<Payment> page = paymentMapper.selectPage(new Page<>(1, 1), wrapper);
        System.out.println("总数量：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("每页几条：" + page.getSize());
        System.out.println("当前页码：" + page.getCurrent());
        List<Payment> list = page.getRecords();
        list.forEach(System.out::println);
    }
}
