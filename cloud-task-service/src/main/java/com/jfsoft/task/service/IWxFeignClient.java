package com.jfsoft.task.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微信客户端
 * wanggang
 * 2017年7月18日 16:24:21
 */
@FeignClient(name = "push-msg",configuration = FeignMultipartSupportConfig.class)
public interface IWxFeignClient {

    @PostMapping(value = "/push")
    String push(@RequestParam(value="info") String info);

}
