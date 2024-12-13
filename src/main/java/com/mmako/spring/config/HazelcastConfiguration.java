package com.mmako.spring.config;

import com.hazelcast.config.*;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableCaching
//
//public class HazelcastConfiguration {
//
//    @Bean
//    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
//        return new HazelcastCacheManager(hazelcastInstance);
//    }
//
//    @Bean
//    public Config hazelcastConfig() {
//        Config config = new Config();
//        config.setInstanceName("hazelcast-instance")
//                .addMapConfig(new MapConfig()
//                        .setName("provinces-cache")
//                        .setEvictionConfig(new EvictionConfig()
//                                .setEvictionPolicy(EvictionPolicy.LRU)
//                        )
//                        .setTimeToLiveSeconds(3600));
//        return config;
//    }
//}
