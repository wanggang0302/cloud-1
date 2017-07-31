package com.jfsoft.task.mapper;

import com.jfsoft.task.entity.TcLisPatientinfo;

import java.util.List;
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
    List<TcLisPatientinfo> getLisPatInfoList(Map<String, Object> params);


    Integer insertTag(Integer patinfoid);

}
