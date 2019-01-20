package com.wip.kyriecao.dao.impl;

import com.wip.kyriecao.dao.IndexDao;
import org.springframework.stereotype.Service;

/**
 * 数据访问层实现
 * @author KyrieCao
 * @date 2019/1/20 21:53
 */
@Service
public class IndexDaoImpl implements IndexDao {
    @Override
    public String getDaoName() {
        return "IndexDao";
    }
}
