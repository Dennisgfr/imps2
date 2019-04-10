/**
 * 房屋管理管理初始化
 */
var Room = {
    id: "RoomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Room.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '房间编号', field: 'fjbh', visible: true, align: 'center', valign: 'middle'},
            {title: '所属大楼编号', field: 'shdl', visible: true, align: 'center', valign: 'middle'},
            {title: '单元号', field: 'dyh', visible: true, align: 'center', valign: 'middle'},
            {title: '楼层号', field: 'lch', visible: true, align: 'center', valign: 'middle'},
            {title: '房间号', field: 'fjh', visible: true, align: 'center', valign: 'middle'},
            {title: '房型', field: 'fx', visible: true, align: 'center', valign: 'middle'},
            {title: '建筑面积', field: 'jzmj', visible: true, align: 'center', valign: 'middle'},
            {title: '使用面积', field: 'symj', visible: true, align: 'center', valign: 'middle'},
            {title: '简要说明', field: 'jysm', visible: true, align: 'center', valign: 'middle'},
            {title: '装修情况', field: 'zxqk', visible: true, align: 'center', valign: 'middle'},
            {title: '业主编号', field: 'yzbh', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Room.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Room.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加房屋管理
 */
Room.openAddRoom = function () {
    var index = layer.open({
        type: 2,
        title: '添加房屋管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/room/room_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看房屋管理详情
 */
Room.openRoomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '房屋管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/room/room_update/' + Room.seItem.fjbh
        });
        this.layerIndex = index;
    }
};

/**
 * 删除房屋管理
 */
Room.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/room/delete", function (data) {
            Feng.success("删除成功!");
            Room.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("roomId",this.seItem.fjbh);
        ajax.start();
    }
};

/**
 * 查询房屋管理列表
 */
Room.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Room.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Room.initColumn();
    var table = new BSTable(Room.id, "/room/list", defaultColunms);
    table.setPaginationType("client");
    Room.table = table.init();
});
