package com.jfsoft.task.mapper;

import java.util.Map;

/**
 * Lis
 * wanggang
 * 2017-7-12 16:44:34
 */
public interface LisMapper {

    /**
     * 调用存储过程，返回检验者者信息
     * @author wanggang
     * 2017/6/30 13:20
     * @param params
     */
    void getLisPatInfoList(Map<String, Object> params);

}
