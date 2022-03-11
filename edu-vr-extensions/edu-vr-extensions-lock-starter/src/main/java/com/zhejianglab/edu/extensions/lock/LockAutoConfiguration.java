package com.zhejianglab.edu.extensions.lock;


import com.zhejianglab.edu.extensions.lock.jdk.JdkLockFactory;
import com.zhejianglab.edu.extensions.lock.redis.RedisLockFactory;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 锁自动化配置
 *
 * @author chengwei
 * @since 2021/6/9
 */
@Configuration
@EnableConfigurationProperties(LockProperties.class)
public class LockAutoConfiguration {

    /**
     * 将基于JDK的锁工厂实现注入到IOC容器，默认策略
     */
    @Bean
    @ConditionalOnMissingBean(LockFactory.class)
    @ConditionalOnProperty(prefix = "lock", name = "policy", havingValue = "jdk", matchIfMissing = true)
    public LockFactory jdkLockFactory() {
        return new JdkLockFactory();
    }

    /**
     * 将基于redis的锁工厂实现注入到IOC容器
     */
    @Bean
    @ConditionalOnBean(RedissonClient.class)
    @ConditionalOnMissingBean(LockFactory.class)
    @ConditionalOnProperty(prefix = "lock", name = "policy", havingValue = "redis")
    public LockFactory redisLockFactory(RedissonClient redissonClient) {
        return new RedisLockFactory(redissonClient);
    }

    /**
     * 将锁模板注入到IOC容器
     */
    @Bean
    public LockTemplate lockTemplate(LockFactory lockFactory) {
        return new DefaultLockTemplate(lockFactory);
    }
}