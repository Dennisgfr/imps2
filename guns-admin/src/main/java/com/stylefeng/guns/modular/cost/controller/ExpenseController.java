package com.stylefeng.guns.modular.cost.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.cost.service.IExpenseService;
import com.stylefeng.guns.modular.system.model.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 缴费信息控制器
 *
 * @author fengshuonan
 * @Date 2019-04-12 09:45:57
 */
@Controller
@RequestMapping("/expenses")
public class ExpenseController extends BaseController {

    private String PREFIX = "/cost/expenses/";

    @Autowired
    private IExpenseService expenseService;

    /**
     * 跳转到缴费信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "expenses.html";
    }

    /**
     * 跳转到添加缴费信息
     */
    @RequestMapping("/expenses_add")
    public String expenseAdd() {
        return PREFIX + "expenses_add.html";
    }

    /**
     * 跳转到修改缴费信息
     */
    @RequestMapping("/expenses_update/{expenseId}")
    public String expenseUpdate(@PathVariable Integer expenseId, Model model) {
        Expenses expenses = expenseService.selectById(expenseId);
        model.addAttribute("item", expenses);
        LogObjectHolder.me().set(expenses);
        return PREFIX + "expenses_edit.html";
    }

    /**
     * 获取缴费信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return expenseService.selectList(null);
    }

    /**
     * 新增缴费信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Expenses expenses) {
        expenseService.insert(expenses);
        return SUCCESS_TIP;
    }

    /**
     * 删除缴费信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer expenseId) {
        expenseService.deleteById(expenseId);
        return SUCCESS_TIP;
    }

    /**
     * 修改缴费信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Expenses expenses) {
        expenseService.updateById(expenses);
        return SUCCESS_TIP;
    }

    /**
     * 缴费信息详情
     */
    @RequestMapping(value = "/detail/{expenseId}")
    @ResponseBody
    public Object detail(@PathVariable("expenseId") Integer expenseId) {
        return expenseService.selectById(expenseId);
    }
}
