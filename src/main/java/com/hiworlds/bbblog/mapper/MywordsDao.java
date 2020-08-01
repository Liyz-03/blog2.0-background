package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.Mywords;

public interface MywordsDao {
    Mywords findMywords();
    void changeMywords(Mywords mywords);
}
