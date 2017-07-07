package com.jfsoft.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.jfsoft.task.entity.PerCheckinfo;
import com.jfsoft.task.entity.TcPerCheckinfo;
import com.jfsoft.task.mapper.PeisMapper;
import com.jfsoft.task.service.ICloudFeignClient;
import com.jfsoft.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by web on 2017/6/29.
 */
@Service
public class ITaskServiceImpl implements ITaskService {

    @Autowired
    private PeisMapper peisMapper;

    @Autowired
    private ICloudFeignClient cloudFeignClient;


    public String getPerCheckInfoProc(String areacode, String rowlimit) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("area_code", areacode);
        params.put("rowlimit", rowlimit);
        params.put("cur_arg_per", new ArrayList<PerCheckinfo>());
        peisMapper.getPerCheckinfoList(params);

        List<PerCheckinfo> perCheckinfoList = (List<PerCheckinfo>) params.get("cur_arg_per");

        String state = "";

        if(null!=perCheckinfoList && perCheckinfoList.size()>0) {
            for(PerCheckinfo perCheckinfo : perCheckinfoList) {
                //生成json
                String perCheckinfoJson = JSON.toJSONString(perCheckinfo);
                TcPerCheckinfo tcPerCheckinfo = JSON.parseObject(perCheckinfoJson, TcPerCheckinfo.class);
                state = cloudFeignClient.peisSave(perCheckinfoJson);
                if(state.equals("OK")){
                    String testno = tcPerCheckinfo.getTestno();
                    peisMapper.saveTag_Id(testno);
                }
            }
        }

        return state;
    }

}
