package edu.stu.gateway.filter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

@Component
public  class MyLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("MyLogFilter"+new Date());
        List<String> iphone = exchange.getRequest().getQueryParams().get("iphone");
        boolean t = iphone.get(0).equals("11111");
        if(!t){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        System.out.println("MyLogFilter"+new Date());
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
}
