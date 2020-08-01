package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.Liuyan;
import com.hiworlds.bbblog.domain.admin.AdminLiuyan;
import com.hiworlds.bbblog.domain.home.HomeLiuyan;

import java.util.List;

public interface LiuyanDao {
    List<Liuyan> findAllLiuyans();
    void saveALiuYan(Liuyan liuyan);

    List<HomeLiuyan> findAllLiuyansForhome();
    List<AdminLiuyan> findAllLiuyanForAdmin();

    void deleteLiuyanById(Integer id);
}
