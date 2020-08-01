package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.Log;

import java.util.List;

public interface LogDao {
    List<Log> findAllLog();

    void deleteLogdeleteLogById(Integer id);

    void changeLogContent(Log log);

    void saveLog(Log log);
}
