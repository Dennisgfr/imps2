package com.stylefeng.guns.modular.employee.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Employee;
import com.stylefeng.guns.modular.employee.service.IEmployeeService;

/**
 * 员工管理控制器
 *
 * @author fengshuonan
 * @Date 2019-04-10 09:49:28
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    private String PREFIX = "/employee/employee/";

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 跳转到员工管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "employee.html";
    }

    /**
     * 跳转到添加员工管理
     */
    @RequestMapping("/employee_add")
    public String employeeAdd() {
        return PREFIX + "employee_add.html";
    }

    /**
     * 跳转到修改员工管理
     */
    @RequestMapping("/employee_update/{employeeId}")
    public String employeeUpdate(@PathVariable Integer employeeId, Model model) {
        Employee employee = employeeService.selectById(employeeId);
        model.addAttribute("item",employee);
        LogObjectHolder.me().set(employee);
        return PREFIX + "employee_edit.html";
    }

    /**
     * 获取员工管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return employeeService.selectList(null);
    }

    /**
     * 新增员工管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Employee employee) {
        employeeService.insert(employee);
        return SUCCESS_TIP;
    }

    /**
     * 删除员工管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer employeeId) {
        employeeService.deleteById(employeeId);
        return SUCCESS_TIP;
    }

    /**
     * 修改员工管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Employee employee) {
        employeeService.updateById(employee);
        return SUCCESS_TIP;
    }

    /**
     * 员工管理详情
     */
    @RequestMapping(value = "/detail/{employeeId}")
    @ResponseBody
    public Object detail(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.selectById(employeeId);
    }
}
