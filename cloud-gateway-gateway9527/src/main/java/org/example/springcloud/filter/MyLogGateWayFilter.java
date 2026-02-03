package org.example.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Description 过滤器
 * @Author fsy
 * @Date 2023/7/27 17:33
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered { // GlobalFilter 全局过滤器    // Ordered过滤器的执行顺序

      @Override
      public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("############# come in MyLogGateWayFilter" + new Date());
            String uname = exchange.getRequest().getQueryParams().getFirst("uname");

            if (uname == null) {
                  log.info("############ 非法用户 ###########");
                  exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
                  return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
      }

      @Override
      public int getOrder() {
            return 0;
      }
}

