//package com.cloudofgoods.order.config.configaration;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class CachingConfig {
//    @Value("${category.cache.name}")
//    private String cacheName;
//    @Bean
//    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return (builder) -> {
//            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
//            configurationMap.put(cacheName, RedisCacheConfiguration.defaultCacheConfig());
//            builder.withInitialCacheConfigurations(configurationMap);
//        };
//    }
//}