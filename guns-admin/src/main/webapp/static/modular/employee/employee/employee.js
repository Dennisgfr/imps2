/**
 * 员工管理管理初始化
 */
var Employee = {
    id: "EmployeeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Employee.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '员工编号', field: 'ygbh', visible: true, align: 'center', valign: 'middle'},
            {title: '员工姓名', field: 'ygxm', visible: true, align: 'center', valign: 'middle'},
            {title: '员工性别', field: 'ygxb', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证', field: 'sfz', visible: true, align: 'center', valign: 'middle'},
            {title: '员工籍贯', field: 'ygjg', visible: true, align: 'center', valign: 'middle'},
            {title: '员工民族', field: 'ygmz', visible: true, align: 'center', valign: 'middle'},
            {title: '工作部门', field: 'deptName', visible: true, align: 'center', valign: 'middle'},
            {title: '入职时间', field: 'rzsj', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'ygdh', visible: true, align: 'center', valign: 'middle'},
            {title: '工作内容', field: 'gznr', visible: true, align: 'center', valign: 'middle'},
            {title: '银行卡号', field: 'yhkh', visible: true, align: 'center', valign: 'middle'},
            {title: '职务', field: 'zw', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Employee.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Employee.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加员工管理
 */
Employee.openAddEmployee = function () {
    var index = layer.open({
        type: 2,
        title: '添加员工管理',
        area: ['1000px', '600px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/employee/employee_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看员工管理详情
 */
Employee.openEmployeeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '员工管理详情',
            area: ['1000px', '600px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/employee/employee_update/' + Employee.seItem.ygbh
        });
        this.layerIndex = index;
    }
};

/**
 * 删除员工管理
 */
Employee.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/employee/delete", function (data) {
            Feng.success("删除成功!");
            Employee.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("employeeId",this.seItem.ygbh);
        ajax.start();
    }
};

/**
 * 查询员工管理列表
 */
Employee.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Employee.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Employee.initColumn();
    var table = new BSTable(Employee.id, "/employee/list", defaultColunms);
    table.setPaginationType("client");
    Employee.table = table.init();
    // var ztree = new $ZTree("deptTree", "/dept/tree");
    // ztree.bindOnClick(Employee.onClickDept);
    // ztree.init();
});
