package com.jfsoft;


import com.jfsoft.task.core.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by web on 2017/6/29.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@MapperScan("com.jfsoft.task.mapper")
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
public class Application {

    //@Bean
    //public HttpMessageConverters fastJsonHttpMessageConverters()
    //{
    //    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    //    FastJsonConfig fastJsonConfig =new FastJsonConfig();
    //    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    //    fastConverter.setFastJsonConfig(fastJsonConfig);
    //    HttpMessageConverter<?> converter = fastConverter;
    //    return new HttpMessageConverters(converter);
    //}

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
