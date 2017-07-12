package com.jfsoft.task.mapper;

import com.jfsoft.task.entity.TcPerCheckinfo;

import java.util.List;
import java.util.Map;

/**
 * Created by web on 2017/6/29.
 */
public interface PeisMapper {

    /**
     * 调用存储过程，返回体检者信息
     * @author wanggang
     * 2017年4月10日 下午2:28:51
     * @param params
     * @return
     */
    List<TcPerCheckinfo> getPerCheckInfoProc(Map<String, Object> params);

}
