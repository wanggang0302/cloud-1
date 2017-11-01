package com.jfsoft.task.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 微信客户端
 * wanggang
 * 2017年7月18日 16:24:21
 */
@FeignClient(name = "push-msg",configuration = FeignMultipartSupportConfig.class)
public interface IWxFeignClient {

    /**
     * 上传报告单数据到微信，并发送微信模板消息
     * ChenXC
     * @param info
     * @param file
     * @return
     */
    @PostMapping(value = "/push", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String push(@RequestParam(value="info") String info, @RequestPart MultipartFile file);


    /**
     * 排队叫号接口
     * 推送排队等待人数
     * @param info
     * @return
     */
    @PostMapping(value = "/wx/push2")
    String push2(@RequestParam(value="info") String info) throws Exception;
}
