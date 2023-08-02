package com.flav.trailers.commons.cache;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCaching
public class CachingSpringBoot implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("movies", "genders", "users");
    }

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(Arrays.asList("movies", "genders"));
    }

}
