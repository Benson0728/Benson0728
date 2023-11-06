package com.cloud.globalfilter;

import com.cloud.utils.JWTutil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(-1)
@Component
public class JwtFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //是否是登录
        if(exchange.getRequest().getURI().getPath().contains("UserLogin")){
            return chain.filter(exchange);
        }
        //获取token
        String token=exchange.getRequest().getHeaders().getFirst("token");
        //校验令牌是否为空且是否合法
        if(token==null||JWTutil.parse(token)==null){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}
