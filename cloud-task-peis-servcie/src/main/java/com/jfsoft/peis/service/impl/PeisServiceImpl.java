package com.jfsoft.peis.service.impl;

import com.alibaba.fastjson.JSON;
import com.jfsoft.peis.entity.PerCheckinfo;
import com.jfsoft.peis.entity.PerGroupitem;
import com.jfsoft.peis.entity.TcPerCheckinfo;
import com.jfsoft.peis.mapper.PeisMapper;
import com.jfsoft.peis.service.IPeisService;
import com.jfsoft.peis.service.IPeisStoreService;
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
public class PeisServiceImpl implements IPeisService {

    @Autowired
    private PeisMapper peisMapper;

    @Autowired
    private IPeisStoreService peisStoreService;

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
                state = peisStoreService.peisSave(perCheckinfoJson);
            }
        }

        return state;
    }

}
