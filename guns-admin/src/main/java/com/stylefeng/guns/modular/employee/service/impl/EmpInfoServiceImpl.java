package com.stylefeng.guns.modular.employee.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.system.model.Employee;
import com.stylefeng.guns.modular.system.dao.EmployeeMapper;
import com.stylefeng.guns.modular.employee.service.IEmpInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EmpInfoServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmpInfoService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Autowired
    private IUserService iUserService;
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

    public boolean addEmp(Employee entity) {

        boolean flag = this.insert(entity);
        /**
         * 注册账号
         */
        if (flag){
            EntityWrapper<Employee> ew = new EntityWrapper<>();
            ew.eq("sfz",entity.getSfz());
            Employee emp = this.selectOne(ew);
            UserDto user = new UserDto();
            user.setName(emp.getYgxm());
            user.setAccount(String.valueOf(emp.getYgbh()));
            user.setPassword("123456");
            user.setDeptid(emp.getGzbm());
            user.setSex(entity.getYgxb());
            user.setCreatetime(entity.getRzsj());
            iUserService.add(user);
        }

        return flag;
    }
}
