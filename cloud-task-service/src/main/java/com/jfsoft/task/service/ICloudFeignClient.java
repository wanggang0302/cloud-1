package com.jfsoft.task.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传到云平台
 * wanggang
 * 2017-7-12 14:36:37
 */
@FeignClient(name = "service-cloud",configuration = FeignMultipartSupportConfig.class)
public interface ICloudFeignClient {

    @PostMapping(value = "/cloud/peisSave")
    String peisSave(@RequestParam(value="info") String info);

    @PostMapping(value = "/cloud/lisSave")
    String lisSave(@RequestParam(value = "info") String info);

    @PostMapping(value = "/cloud/uploadPic", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadPic(@RequestPart MultipartFile file, @RequestParam(value = "picSize") Long picSize,
                     @RequestParam(value = "hospital_code") String hospital_code, @RequestParam(value = "upType") String upType);

    @PostMapping(value = "/cloud/pullReg")
    String pullReg(@RequestParam(value="hospitalCode") String hospitalCode);

    @PostMapping(value = "/cloud/updateState")
    String updateState(@RequestParam(value="patinfoIdList") String patinfoIdList);

}
