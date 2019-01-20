package com.wip.kyriecao.service.impl;

import com.wip.kyriecao.dao.IndexDao;
import com.wip.kyriecao.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 接口实现
 * @author KyrieCao
 * @date 2019/1/20 21:38
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao;

    @Override
    public String getDaoName() {
        return indexDao.getDaoName();
    }
}
