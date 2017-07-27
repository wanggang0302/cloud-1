package com.jfsoft.task.mapper;

import com.jfsoft.task.entity.TcPerCheckinfo;

import java.util.List;
import java.util.Map;

/**
 * PEIS
 * wanggang
 * 2017-7-13 08:37:16
 */
public interface PeisMapper {

    /**
     * 调用存储过程，返回体检者信息
     * @author wanggang
     * 2017年4月10日 下午2:28:51
     * @param params
     * @return
     */
    List<TcPerCheckinfo> getPerCheckinfoList(Map<String, Object> params);

    /**
     * 调用存储过程，设置体检者数据状态
     * wanggang
     * 2017-07-27 09:51:39
     */
    void updatePerCheckinfoState(Map<String, Object> params);

}
