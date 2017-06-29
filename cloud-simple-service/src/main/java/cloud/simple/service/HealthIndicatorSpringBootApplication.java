/**
 * @(#)EurekaServer.java, 十月 28, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cloud.simple.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//http://blog.csdn.net/clementad/article/details/52045495
//@SpringBootApplication  
//@EnableScheduling  
//public class HealthIndicatorSpringBootApplication implements HealthIndicator{  
//    private static Logger logger = LoggerFactory.getLogger(HealthIndicatorSpringBootApplication.class);  
//      
//    public static void main(String[] args) {  
//        SpringApplication.run(HealthIndicatorSpringBootApplication.class, args);  
//        logger.info("My Spring Boot Application Started");  
//    }  
//  
//    /** 
//     * 在/health接口调用的时候，返回多一个属性："mySpringBootApplication":{"status":"UP","hello":"world"} 
//     */  
//    @Override  
//    public Health health() {  
//        return Health.up().withDetail("hello", "world").build();  
//    }  
//}  