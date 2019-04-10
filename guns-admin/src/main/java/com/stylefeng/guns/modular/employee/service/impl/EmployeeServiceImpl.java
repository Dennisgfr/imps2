package com.stylefeng.guns.modular.employee.service.impl;

import com.stylefeng.guns.modular.system.model.Employee;
import com.stylefeng.guns.modular.system.dao.EmployeeMapper;
import com.stylefeng.guns.modular.employee.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
