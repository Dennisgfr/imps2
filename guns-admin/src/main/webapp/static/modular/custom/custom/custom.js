/**
 * 业主管理管理初始化
 */
var Custom = {
    id: "CustomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Custom.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '业主编号 ', field: 'yzbh', visible: true, align: 'center', valign: 'middle'},
            {title: '业主姓名', field: 'yzxm', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'xb', visible: true, align: 'center', valign: 'middle'},
            {title: '业主籍贯', field: 'jg', visible: true, align: 'center', valign: 'middle'},
            {title: '证件类型', field: 'zjlx', visible: true, align: 'center', valign: 'middle'},
            {title: '证件号码', field: 'zjhm', visible: true, align: 'center', valign: 'middle'},
            {title: '业主电话', field: 'yzdh', visible: true, align: 'center', valign: 'middle'},
            {title: '业主居住楼层', field: 'yzjulc', visible: true, align: 'center', valign: 'middle'},
            {title: '业主居住房间号', field: 'yzjzfjh', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Custom.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Custom.seItem = selected[0];
        console.log(selected[0].yzbh);
        return true;
    }
};

/**
 * 点击添加业主管理
 */
Custom.openAddCustom = function () {
    var index = layer.open({
        type: 2,
        title: '添加业主管理',
        area: ['1000px', '600px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/custom/custom_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看业主管理详情
 */
Custom.openCustomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '业主管理详情',
            area: ['1000px', '600px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/custom/custom_update/' + Custom.seItem.yzbh
        });
        this.layerIndex = index;
    }
};

/**
 * 删除业主管理
 */
Custom.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/custom/delete", function (data) {
            Feng.success("删除成功!");
            Custom.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("customId",this.seItem.yzbh);
        ajax.start();
    }
};

/**
 * 查询业主管理列表
 */
Custom.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Custom.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Custom.initColumn();
    var table = new BSTable(Custom.id, "/custom/list", defaultColunms);
    table.setPaginationType("client");
    Custom.table = table.init();
});
