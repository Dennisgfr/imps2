package com.stylefeng.guns.modular.employee.service;

import com.stylefeng.guns.modular.system.model.Employee;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工信息表 服务类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
public interface IEmployeeService extends IService<Employee> {
    Employee selectById(Integer employeeId);
    int deleteById(Integer employeeId);
    public boolean update(Employee entity);
    List<Map<String, Object>> selectEmployees(String condition);
}
