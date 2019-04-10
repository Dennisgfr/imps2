package com.stylefeng.guns.modular.room.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Room;
import com.stylefeng.guns.modular.room.service.IRoomService;

/**
 * 房屋管理控制器
 *
 * @author fengshuonan
 * @Date 2019-04-10 09:51:09
 */
@Controller
@RequestMapping("/room")
public class RoomController extends BaseController {

    private String PREFIX = "/room/room/";

    @Autowired
    private IRoomService roomService;

    /**
     * 跳转到房屋管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "room.html";
    }

    /**
     * 跳转到添加房屋管理
     */
    @RequestMapping("/room_add")
    public String roomAdd() {
        return PREFIX + "room_add.html";
    }

    /**
     * 跳转到修改房屋管理
     */
    @RequestMapping("/room_update/{roomId}")
    public String roomUpdate(@PathVariable Integer roomId, Model model) {
        Room room = roomService.selectById(roomId);
        model.addAttribute("item",room);
        LogObjectHolder.me().set(room);
        return PREFIX + "room_edit.html";
    }

    /**
     * 获取房屋管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        if(condition == null || condition.equals("") ){
            return roomService.selectList(null);
        }else{
            EntityWrapper<Room> ew = new EntityWrapper<>();
            ew.eq("fjbh","condition");
            return roomService.selectList(ew);
        }

    }

    /**
     * 新增房屋管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Room room) {
        roomService.insert(room);
        return SUCCESS_TIP;
    }

    /**
     * 删除房屋管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer roomId) {
        roomService.deleteById(roomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改房屋管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Room room) {
        roomService.updateById(room);
        return SUCCESS_TIP;
    }

    /**
     * 房屋管理详情
     */
    @RequestMapping(value = "/detail/{roomId}")
    @ResponseBody
    public Object detail(@PathVariable("roomId") Integer roomId) {
        return roomService.selectById(roomId);
    }
}
