package com.wip.kyriecao.controller;

import com.wip.kyriecao.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台首页控制器
 * @author KyrieCao
 * @date 2019/1/20 21:33
 */
@RestController
public class IndexAdminController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/admin")
    public String index() {
        return "Welcome to Admin, Dao名称为：" + indexService.getDaoName();
    }

}
