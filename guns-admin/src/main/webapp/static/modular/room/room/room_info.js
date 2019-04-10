/**
 * 初始化房屋管理详情对话框
 */
var RoomInfoDlg = {
    roomInfoData : {}
};

/**
 * 清除数据
 */
RoomInfoDlg.clearData = function() {
    this.roomInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RoomInfoDlg.set = function(key, val) {
    this.roomInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RoomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RoomInfoDlg.close = function() {
    parent.layer.close(window.parent.Room.layerIndex);
}

/**
 * 收集数据
 */
RoomInfoDlg.collectData = function() {
    this
    .set('fjbh')
    .set('shdl')
    .set('dyh')
    .set('lch')
    .set('fjh')
    .set('fx')
    .set('jzmj')
    .set('symj')
    .set('jysm')
    .set('zxqk')
    .set('yzbh');
}

/**
 * 提交添加
 */
RoomInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/room/add", function(data){
        Feng.success("添加成功!");
        window.parent.Room.table.refresh();
        RoomInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.roomInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RoomInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/room/update", function(data){
        Feng.success("修改成功!");
        window.parent.Room.table.refresh();
        RoomInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.roomInfoData);
    ajax.start();
}

$(function() {

});
