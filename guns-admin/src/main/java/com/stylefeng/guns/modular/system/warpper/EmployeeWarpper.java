package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import java.util.List;
import java.util.Map;

public class EmployeeWarpper extends BaseControllerWarpper {
    public EmployeeWarpper(List<Map<String, Object>> list) {
        super(list);
        System.out.println(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("deptName", ConstantFactory.me().getDeptName((Integer) map.get("gzbm")));

    }

}
