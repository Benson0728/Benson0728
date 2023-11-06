package com.cloud;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaseLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseLoginApplication.class, args);
    }

    @Bean
    public MybatisPlusInterceptor pageInterceptor() {
        MybatisPlusInterceptor mpt = new MybatisPlusInterceptor();
        mpt.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpt;

    }
}
