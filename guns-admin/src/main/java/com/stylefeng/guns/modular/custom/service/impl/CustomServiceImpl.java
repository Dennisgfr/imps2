package com.stylefeng.guns.modular.custom.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.room.service.IRoomService;
import com.stylefeng.guns.modular.system.model.Custom;
import com.stylefeng.guns.modular.system.dao.CustomMapper;
import com.stylefeng.guns.modular.custom.service.ICustomService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.model.Room;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 业主信息表 服务实现类
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@Service
@Transactional
public class CustomServiceImpl extends ServiceImpl<CustomMapper, Custom> implements ICustomService {

    @Autowired
    private ICustomService iCustomService;
    @Autowired
    private IRoomService iRoomService;
    @Autowired
    private IUserService iUserService;

    /**
     * 添加业主
     * @param entity
     * @return
     */
    @Override
    public boolean insert(Custom entity) {
        /**
         * 判断楼层房间是否存在
         */
        /**
         * 生成业主编号
         */
        String lc = entity.getYzjulc();
        String fjh = entity.getYzjzfjh();
        String ws = entity.getZjhm().substring(entity.getZjhm().length()- 3,entity.getZjhm().length());
        String code = lc + fjh + ws;
        entity.setYzbh(code);
        boolean insert = super.insert(entity);
        boolean flag = insert;
        /**
         * 注册账号
         */
        UserDto user = new UserDto();
        user.setName(entity.getYzxm());
        user.setAccount(code);  //业主编号 作为账户名
        user.setPassword("123456"); //初始密码为 123456
        user.setRoleid("12");  //角色 业主
        user.setDeptid(29);  //部门 业主委员会
        user.setSex(entity.getXb());
        user.setCreatetime(entity.getCjsj());
        iUserService.add(user);




        /**
         * 修改房间所属状态
         */
        Room room = new Room();
        room.setYzbh(code);
        EntityWrapper<Room> ew = new EntityWrapper<>();
        System.out.println(lc+fjh);
        ew.eq("fjbh",lc+fjh);
        flag = iRoomService.update(room,ew);

        return flag;
    }

    @Override
    public boolean delete(String customId) {
        /**
         * 删除业主
         */
        EntityWrapper<Custom> ew = new EntityWrapper<>();
        ew.eq("yzbh",customId);
        iCustomService.delete(ew);
        /**
         * 房屋归还
         */
        Room room = new Room();
        room.setYzbh("");
        EntityWrapper<Room> ewr = new EntityWrapper<>();
        ewr.eq("yzbh",customId);
        boolean flag = iRoomService.update(room,ewr);
        return flag;
    }
}
