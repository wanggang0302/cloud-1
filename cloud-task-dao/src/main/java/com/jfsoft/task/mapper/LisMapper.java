package com.jfsoft.task.mapper;

import java.util.Map;

/**
 * Created by web on 2017/7/7.
 */
public interface LisMapper {
    /**
     * 调用存储过程，返回检验者者信息
     * @author wanggang
     * 2017/6/30 13:20
     * @param params
     */
    void getLisPatientInfoList(Map<String, Object> params);
}
