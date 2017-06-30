package com.jfsoft.peis.service.impl;

import com.jfsoft.peis.entity.PerCheckinfo;
import com.jfsoft.peis.entity.PerGroupitem;
import com.jfsoft.peis.mapper.PeisMapper;
import com.jfsoft.peis.service.IPeisService;
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

    public String getPerCheckInfoProc(String testno, String areacode) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("testno", testno);
        params.put("areacode", areacode);
        params.put("cur_arg_per", new ArrayList<PerCheckinfo>());
        params.put("cur_arg_item", new ArrayList<PerGroupitem>());
        //peisMapper.getPerCheckInfoProc(params);

        Map<String, Object> params1 = new HashMap<String, Object>();
        params1.put("areacode", areacode);
        params1.put("usercode", "1");
        peisMapper.getTestNo(params1);
        Object obj = params1.get("testno");

        String testno1 = null!=obj?obj.toString():"";
        System.out.println("==============" + testno1);


        List<PerCheckinfo> perCheckinfoList = (List<PerCheckinfo>) params.get("cur_arg_per");
        List<PerGroupitem> PerGroupitemList = (List<PerGroupitem>) params.get("cur_arg_item");

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("perCheckinfo", perCheckinfoList);
        data.put("PerGroupitemList", PerGroupitemList);

        return testno1;
    }

}
