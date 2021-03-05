package com.it.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon负载均衡：
 *
 * RoundRobinRule：轮询
 * RandomRule：随机
 * RetryRule：先按照轮询方式，如果轮询到某个服务失败了，将会在指定时间内进行重试
 * WeightedResponseTimeRule：对轮询的扩展，响应速度越快的权重越大，被选择的机会越大
 * BestAvailableRule：会先过滤经常出问题的服务，然后选择一个最闲的服务
 * AvailabilityFilteringRule：先过滤故障实例，再选择并发量最小的
 * ZoneAvoidanceRule：默认规则，复合判断server所在区域的性能和server可用性选择服务器
 *
 * 需要在启动类上加注解
 * @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration=MyRibbonRule.class)
 *
 * @author luyian
 */
@Configuration
public class MyRibbonRule {
    /**
     * Ribbon自带有7中算法，在配置类中new对应的类即可。
     * 也可以自己写负载均衡算法
     *
     * 随机
     * @return
     */
    @Bean
    public IRule randRule() {
        return new RandomRule();
    }
}
