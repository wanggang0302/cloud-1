package com.jfsoft.task.mapper;


import com.jfsoft.task.entity.RegPatientinfo;

import java.util.List;
import java.util.Map;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/9/25  11:39
 * @Description TODO(一句话描述类作用)
 */
public interface RegPatientinfoMapper {

    /**
     * 调用存储过程插入ChnInteface
     * @param regPatientinfo
     * @return
     */
    Integer insertRegInfo(RegPatientinfo regPatientinfo);

    List<RegPatientinfo> updateState();
}
