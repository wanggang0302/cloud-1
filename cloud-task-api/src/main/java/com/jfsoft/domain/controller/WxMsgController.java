package com.jfsoft.domain.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfsoft.task.service.IWxFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/10/20  9:28
 * @Description TODO(一句话描述类作用)
 */
@RestController
@RequestMapping("/wx")
public class WxMsgController {

    private static Logger logger = LoggerFactory.getLogger(WxMsgController.class);

    @Autowired
    private IWxFeignClient wxFeignClient;

    //医院编码
    @Value("${spring.application.name}")
    private String hospitalId;

    @PostMapping("/Queuing")
    @ResponseBody
    public String pushWxMessageQueuing(String info) {

        Map<String, Object> map = new HashMap<>(16);

        JSONObject json = null;

        try {
           String result =  wxFeignClient.push2(info);
           json = JSON.parseObject(result);
           if(json.getString("status").equals("success")) {
                map.put("status", "success");
                logger.info("推送成功");
           } else {
               map.put("status", "failure");
               map.put("errcode", json.getInteger("errcode"));
               map.put("errmsg", json.getString("errmsg"));
           }
        }catch (Exception e) {
            map.put("status", "application push error");
            map.put("errcode", json.getInteger("errcode"));
            map.put("errmsg", json.getString("errmsg"));
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}

