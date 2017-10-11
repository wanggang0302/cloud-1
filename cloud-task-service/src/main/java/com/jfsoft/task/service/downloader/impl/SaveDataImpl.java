package com.jfsoft.task.service.downloader.impl;

import com.alibaba.fastjson.JSONObject;
import com.jfsoft.task.entity.RegPatientinfo;
import com.jfsoft.task.mapper.RegPatientinfoMapper;
import com.jfsoft.task.service.downloader.ISaveDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/10/11  9:41
 * @Description TODO(一句话描述类作用)
 */
@Service
public class SaveDataImpl implements ISaveDate {

    @Autowired
    private RegPatientinfoMapper regPatientinfoMapper;

    /**
     * 保存已注册人员
     *
     * @param regInfo
     * @return
     * @throws Exception
     */
    @Override
    public int saveRegInfo(String regInfo) throws Exception {

        RegPatientinfo regPatientinfo = JSONObject.parseObject(regInfo, RegPatientinfo.class);


        return regPatientinfoMapper.insertRegInfo(regPatientinfo);
    }
}
