package com.jfsoft.task.service.downloader.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfsoft.task.entity.RegPatientinfo;
import com.jfsoft.task.mapper.RegPatientinfoMapper;
import com.jfsoft.task.service.downloader.ISaveDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Integer saveRegInfo(String regInfo) throws Exception {

        JSONObject jsonObject = JSON.parseObject(regInfo);
        String regInfos = jsonObject.getString("regInfo");
        List<RegPatientinfo> regPatientinfoList = JSON.parseArray(regInfos, RegPatientinfo.class);
        Integer count = 0;
        for (RegPatientinfo reg : regPatientinfoList) {
            regPatientinfoMapper.insertRegInfo(reg);
        }
        return 1;
    }

    /**
     * 获取已接收标本的ID
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<RegPatientinfo> updateState() throws Exception {
        return regPatientinfoMapper.updateState();
    }
}
