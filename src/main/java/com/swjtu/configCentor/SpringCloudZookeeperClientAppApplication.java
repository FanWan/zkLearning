package com.swjtu.configCentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wanfan01 on 2018/8/3.
 *
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudZookeeperClientAppApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringCloudZookeeperClientAppApplication.class, args);
        }

}
