package com.jfsoft.log.service.impl;

import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.core.TargetDataSource;
import com.jfsoft.task.entity.TcLog;
import com.jfsoft.task.mapper.TcLogMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志保存业务接口实现类
 * wanggang
 * 2017-7-10 16:00:53
 */
@Service
public class TcLogServiceImpl implements ITcLogService {

    @Autowired
    private TcLogMapper tcLogMapper;

    //@TargetDataSource(name="mysql")
    public Map<String, Long> selectUploadFailureLog(String upType) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("upType", upType);

        List<Map<String, Object>> resultList = tcLogMapper.selectUploadFailureLog(params);

        Map<String, Long> result = new HashMap<String, Long>();
        for(Map<String, Object> map : resultList) {
            String upDataId = null!=map.get("upDataId")?map.get("upDataId").toString():"";
            Long count = null!=map.get("count")?Long.parseLong(map.get("count").toString()):0l;
            result.put(upDataId, count);
        }

        return result;
    }

    //@TargetDataSource(name="mysql")
    public void save(TcLog tcLog) throws Exception {

        tcLogMapper.insert(tcLog);
    }

    //@TargetDataSource(name="mysql")
    public List<TcLog>  findList(String upMechName, String upType, String upStatus,
                                String upDateBegin, String upDateEnd) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        if(!StringUtils.isBlank(upType)) {
            params.put("upType", upType);
        }
        if(!StringUtils.isBlank(upStatus)) {
            params.put("upStatus", upStatus);
        }
        if(!StringUtils.isBlank(upDateBegin)) {
            params.put("upDateBegin", upDateBegin + " 00:00:00");
        }
        if(!StringUtils.isBlank(upDateEnd)) {
            //between ... and ...（包含关系）
            params.put("upDateEnd", upDateEnd + " 23:59:59");
        }

        return tcLogMapper.selectLogList(params);
    }

}
