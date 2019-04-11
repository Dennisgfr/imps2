package com.stylefeng.guns.modular.employee.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.modular.system.model.Employee;
import com.stylefeng.guns.modular.system.dao.EmployeeMapper;
import com.stylefeng.guns.modular.employee.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public Employee selectById(Integer employeeId) {
        return employeeMapper.selectById(employeeId);
    }

    @Override
    public int deleteById(Integer employeeId) {
        return employeeMapper.deleteById(employeeId);
    }

    public boolean update(Employee entity) {
        EntityWrapper<Employee> ew = new EntityWrapper<>();
        ew.eq("ygbh", entity.getYgbh());
        return super.update(entity, ew);
    }

    @Override
    public List<Map<String, Object>> selectEmployees(String condition) {
        if (condition == null || condition.equals("")){
            return employeeMapper.selectMaps(null);
        }else {
            EntityWrapper<Employee> ew = new EntityWrapper<>();
            ew.eq("ygbh",condition);
            return employeeMapper.selectMaps(ew);
        }
    }
}
