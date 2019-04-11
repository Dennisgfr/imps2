package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.io.Serializable;

/**
 * <p>
 * 员工信息表 Mapper 接口
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    Employee selectById(Integer employeeId);
    int deleteById(Integer customId);

}
