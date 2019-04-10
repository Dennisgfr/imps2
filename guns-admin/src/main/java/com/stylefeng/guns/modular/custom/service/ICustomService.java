package com.stylefeng.guns.modular.custom.service;

import com.stylefeng.guns.modular.system.model.Custom;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 业主信息表 服务类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
public interface ICustomService extends IService<Custom> {
    @Override
    boolean insert(Custom custom);


    boolean delete(String customId);
}
