
package com.futao.springboot.learn.rabbitmq.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author futao
 * @date 2020/3/9.
 */
@Configuration
public class MybatisPlusConfig implements MetaObjectHandler {

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createDateTime", LocalDateTime.now(ZoneOffset.ofHours(8)), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateDateTime", LocalDateTime.now(ZoneOffset.ofHours(8)), metaObject);
    }
}