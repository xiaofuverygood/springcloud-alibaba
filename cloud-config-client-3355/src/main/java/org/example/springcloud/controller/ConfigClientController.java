package org.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2023/10/19 10:16
 */
@RestController
@RefreshScope
@RequestMapping("/configCenter")
public class ConfigClientController {

      @Value("${config.info}")
      private String configInfo;

      @GetMapping("/getConfigInfo")
      public String getConfigInfo() {

            return configInfo;
      }
}
