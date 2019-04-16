/**
 * 工作安排管理初始化
 */
var Work = {
    id: "WorkTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Work.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '员工编号', field: 'ygbh', visible: true, align: 'center', valign: 'middle'},
            {title: '员工姓名', field: 'ygxm', visible: true, align: 'center', valign: 'middle'},
            {title: '工作日期', field: 'gzrq', visible: true, align: 'center', valign: 'middle'},
            {title: '工作地点', field: 'gzdd', visible: true, align: 'center', valign: 'middle'},
            {title: '工作任务', field: 'gzrw', visible: true, align: 'center', valign: 'middle'},
            {title: '具体项目', field: 'jtxm', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Work.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Work.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加工作安排
 */
Work.openAddWork = function () {
    var index = layer.open({
        type: 2,
        title: '添加工作安排',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/work/work_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看工作安排详情
 */
Work.openWorkDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '工作安排详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/work/work_update/' + Work.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除工作安排
 */
Work.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/work/delete", function (data) {
            Feng.success("删除成功!");
            Work.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("workId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询工作安排列表
 */
Work.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Work.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Work.initColumn();
    var table = new BSTable(Work.id, "/work/list", defaultColunms);
    table.setPaginationType("client");
    Work.table = table.init();
});
