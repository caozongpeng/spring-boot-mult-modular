package com.wip.kyriecao.controller;

import com.wip.kyriecao.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台首页控制器
 * @author KyrieCao
 * @date 2019/1/20 21:35
 */
@RestController
public class IndexFrontController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public String index() {
        return "Welcome to Front, Dao名称为：" + indexService.getDaoName();
    }
}
