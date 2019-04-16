package com.stylefeng.guns.modular.cost.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.cost.service.IExpenseService;
import com.stylefeng.guns.modular.system.dao.ExpenseMapper;
import com.stylefeng.guns.modular.system.model.Expenses;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业主收费管理表 服务实现类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-12
 */
@Service
public class ExpenseServiceImpl extends ServiceImpl<ExpenseMapper, Expenses> implements IExpenseService {

}
