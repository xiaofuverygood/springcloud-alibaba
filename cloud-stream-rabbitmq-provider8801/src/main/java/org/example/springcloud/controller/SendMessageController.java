package org.example.springcloud.controller;

import org.example.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/2/21 09:20
 */
@RestController
public class SendMessageController {
      @Resource
      private IMessageProvider messageProvider;

      @GetMapping(value = "/sendMessage")
      public String sendMessage() {
            return messageProvider.send();
      }
}