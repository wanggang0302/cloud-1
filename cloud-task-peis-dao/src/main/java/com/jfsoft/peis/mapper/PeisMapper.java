package com.jfsoft.peis.mapper;

import com.jfsoft.peis.entity.PerCheckinfo;

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
    List<PerCheckinfo> getPerCheckInfoProc(Map<String, Object> params);

    /**
     * 获得体检号
     * @author wanggang
     * 2017年3月27日 下午7:32:11
     * @param params
     * @return
     */
    String getTestNo(Map<String, Object> params);

}
