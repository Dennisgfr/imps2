package com.stylefeng.guns.modular.fix.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Fix;
import com.stylefeng.guns.modular.fix.service.IFixService;

/**
 * 维修记录控制器
 *
 * @author fengshuonan
 * @Date 2019-04-10 09:50:44
 */
@Controller
@RequestMapping("/fix")
public class FixController extends BaseController {

    private String PREFIX = "/fix/fix/";

    @Autowired
    private IFixService fixService;

    /**
     * 跳转到维修记录首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "fix.html";
    }

    /**
     * 跳转到添加维修记录
     */
    @RequestMapping("/fix_add")
    public String fixAdd() {
        return PREFIX + "fix_add.html";
    }

    /**
     * 跳转到修改维修记录
     */
    @RequestMapping("/fix_update/{fixId}")
    public String fixUpdate(@PathVariable Integer fixId, Model model) {
        Fix fix = fixService.selectById(fixId);
        model.addAttribute("item",fix);
        LogObjectHolder.me().set(fix);
        return PREFIX + "fix_edit.html";
    }

    /**
     * 获取维修记录列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return fixService.selectList(null);
    }

    /**
     * 新增维修记录
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Fix fix) {
        fixService.insert(fix);
        return SUCCESS_TIP;
    }

    /**
     * 删除维修记录
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer fixId) {
        fixService.deleteById(fixId);
        return SUCCESS_TIP;
    }

    /**
     * 修改维修记录
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Fix fix) {
        fixService.updateById(fix);
        return SUCCESS_TIP;
    }

    /**
     * 维修记录详情
     */
    @RequestMapping(value = "/detail/{fixId}")
    @ResponseBody
    public Object detail(@PathVariable("fixId") Integer fixId) {
        return fixService.selectById(fixId);
    }
}
