package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.CaiCai;
import com.hiworlds.bbblog.domain.admin.LogcaicaiCity;

import java.util.List;

/**
 *  @author: Liyz
 *  @Date: 2020/7/23 14:06
 *  @Description:
 **/

public interface CaicaiDao {
    List<CaiCai> findAllLogCaicai();
    void setALogCaicai(CaiCai caicai);
    List<LogcaicaiCity> findLogcaicaiCity();
}
