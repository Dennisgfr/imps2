package com.stylefeng.guns.modular.fix.service.impl;

import com.stylefeng.guns.modular.system.model.Fix;
import com.stylefeng.guns.modular.system.dao.FixMapper;
import com.stylefeng.guns.modular.fix.service.IFixService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 室内维修记录表 服务实现类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@Service
public class FixServiceImpl extends ServiceImpl<FixMapper, Fix> implements IFixService {

}
