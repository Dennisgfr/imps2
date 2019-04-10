package com.stylefeng.guns.modular.room.service;

import com.stylefeng.guns.modular.system.model.Room;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 房屋信息表 服务类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
public interface IRoomService extends IService<Room> {
    @Override
    boolean insert(Room room);
}
