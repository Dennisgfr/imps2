package com.stylefeng.guns.modular.custom.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Custom;
import com.stylefeng.guns.modular.custom.service.ICustomService;

/**
 * 业主管理控制器
 *
 * @author fengshuonan
 * @Date 2019-04-10 10:31:22
 */
@Controller
@RequestMapping("/custom")
public class CustomController extends BaseController {

    private String PREFIX = "/custom/custom/";

    @Autowired
    private ICustomService customService;

    /**
     * 跳转到业主管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "custom.html";
    }

    /**
     * 跳转到添加业主管理
     */
    @RequestMapping("/custom_add")
    public String customAdd() {
        return PREFIX + "custom_add.html";
    }

    /**
     * 跳转到修改业主管理
     */
    @RequestMapping("/custom_update/{customId}")
    public String customUpdate(@PathVariable Integer customId, Model model) {
        Custom custom = customService.selectById(customId);
        model.addAttribute("item",custom);
        LogObjectHolder.me().set(custom);
        return PREFIX + "custom_edit.html";
    }

    /**
     * 获取业主管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return customService.selectList(null);
    }

    /**
     * 新增业主管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Custom custom) {
        customService.insert(custom);
        return SUCCESS_TIP;
    }

    /**
     * 删除业主管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer customId) {
        customService.deleteById(customId);
        return SUCCESS_TIP;
    }

    /**
     * 修改业主管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Custom custom) {
        customService.updateById(custom);
        return SUCCESS_TIP;
    }

    /**
     * 业主管理详情
     */
    @RequestMapping(value = "/detail/{customId}")
    @ResponseBody
    public Object detail(@PathVariable("customId") Integer customId) {
        return customService.selectById(customId);
    }
}
