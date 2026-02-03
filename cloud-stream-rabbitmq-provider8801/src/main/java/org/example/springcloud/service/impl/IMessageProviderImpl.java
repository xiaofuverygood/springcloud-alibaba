package org.example.springcloud.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/2/21 09:21
 */
@EnableBinding(Source.class) //定义消息的推送管道
@RequiredArgsConstructor
public class IMessageProviderImpl implements IMessageProvider {

      private final MessageChannel output; //消息发送管道

      @Override
      public String send() {
            String serial = UUID.randomUUID().toString();
            output.send(MessageBuilder.withPayload(serial).build());
            System.out.println("传输的消息内容：" + serial);
            return null;
      }
}