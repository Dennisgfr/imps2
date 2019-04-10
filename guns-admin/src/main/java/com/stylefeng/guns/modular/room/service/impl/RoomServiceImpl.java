package com.stylefeng.guns.modular.room.service.impl;

import com.stylefeng.guns.modular.system.model.Room;
import com.stylefeng.guns.modular.system.dao.RoomMapper;
import com.stylefeng.guns.modular.room.service.IRoomService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 房屋信息表 服务实现类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@Service
@Transactional
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements IRoomService {
    @Override
    public boolean insert(Room entity) {
        String lfh = entity.getShdl();
        String fjh = entity.getFjh();
        entity.setFjbh(lfh+fjh);

        return super.insert(entity);
    }
}
