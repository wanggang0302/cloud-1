package com.jfsoft.peis.controller;

import com.jfsoft.peis.entity.TcPerCheckinfo;
import com.jfsoft.peis.service.IPeisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by web on 2017/6/28.
 */
@RestController
public class PeisController {

    @Autowired
    private IPeisService peisService;

    /**
     * spring cloud测试
     */
    @Value("${server.port}")
    String port;
    @RequestMapping("/test")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }


    /**
     * 体检人员信息保存接口
     * @param tcPerCheckinfo
     * @return
     */
    @PostMapping(value = "/peisSave")

    public HttpEntity peisSave(@ModelAttribute TcPerCheckinfo tcPerCheckinfo){
        peisService.insertPeisPercheckinfo(tcPerCheckinfo);
        return new ResponseEntity<>(tcPerCheckinfo, HttpStatus.ACCEPTED);
    }
}
