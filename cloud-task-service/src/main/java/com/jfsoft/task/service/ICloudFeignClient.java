package com.jfsoft.task.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by web on 2017/6/30.
 */
@FeignClient(name = "service-cloud",configuration = FeignMultipartSupportConfig.class)
public interface ICloudFeignClient {

    @PostMapping(value = "/cloud/peisSave")
    String peisSave(@RequestParam(value="info") String info);

    @PostMapping(value = "/cloud/lisSave")
    String lisSave(@RequestParam(value = "info") String info);

    @PostMapping(value = "/cloud/uploadPic", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String,Object> uploadPic(@RequestPart MultipartFile file);
}
