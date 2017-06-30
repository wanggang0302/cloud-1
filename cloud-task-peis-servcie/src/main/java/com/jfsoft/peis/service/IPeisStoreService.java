package com.jfsoft.peis.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by web on 2017/6/30.
 */
@FeignClient(value = "service-peis")
public interface IPeisStoreService {

    @PostMapping(value = "/peisSave")
    String peisSave(@RequestParam(value = "testno") String testno);

}
