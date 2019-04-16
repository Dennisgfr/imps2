package com.stylefeng.guns.modular.employee.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.WorkMapper;
import com.stylefeng.guns.modular.system.model.Work;
import com.stylefeng.guns.modular.employee.service.IWorkService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作安排表 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2019-04-11
 */
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements IWorkService {

}
