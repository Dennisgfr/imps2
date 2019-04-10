/**
 * 维修记录管理初始化
 */
var Fix = {
    id: "FixTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Fix.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '房间编号', field: 'fjbh', visible: true, align: 'center', valign: 'middle'},
            {title: '业主姓名', field: 'yzxm', visible: true, align: 'center', valign: 'middle'},
            {title: '业主电话', field: 'yzdh', visible: true, align: 'center', valign: 'middle'},
            {title: '维修项目', field: 'wxxm', visible: true, align: 'center', valign: 'middle'},
            {title: '维修日期', field: 'wxrq', visible: true, align: 'center', valign: 'middle'},
            {title: '维修人编号', field: 'wxrybh', visible: true, align: 'center', valign: 'middle'},
            {title: '维修人姓名', field: 'wxrxm', visible: true, align: 'center', valign: 'middle'},
            {title: '业主评价', field: 'yzpj', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'bz', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Fix.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Fix.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加维修记录
 */
Fix.openAddFix = function () {
    var index = layer.open({
        type: 2,
        title: '添加维修记录',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/fix/fix_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看维修记录详情
 */
Fix.openFixDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '维修记录详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/fix/fix_update/' + Fix.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除维修记录
 */
Fix.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/fix/delete", function (data) {
            Feng.success("删除成功!");
            Fix.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("fixId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询维修记录列表
 */
Fix.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Fix.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Fix.initColumn();
    var table = new BSTable(Fix.id, "/fix/list", defaultColunms);
    table.setPaginationType("client");
    Fix.table = table.init();
});
