/**
 * 初始化员工管理详情对话框
 */
var EmployeeInfoDlg = {
    employeeInfoData : {}
};

/**
 * 清除数据
 */
EmployeeInfoDlg.clearData = function() {
    this.employeeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EmployeeInfoDlg.set = function(key, val) {
    this.employeeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EmployeeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EmployeeInfoDlg.close = function() {
    parent.layer.close(window.parent.Employee.layerIndex);
}

/**
 * 点击部门input框时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
EmployeeInfoDlg.onClickDept = function (e, treeId, treeNode) {
    $("#citysel").attr("value", instance.getSelectedVal());
    console.log($("#citysel"));
    console.log("点击");
    console.log(treeNode);
    $("#gzbm").attr("value", treeNode.id);
    var jobTree = $ZTree()

};

/**
 * 显示部门选择的树
 *
 * @returns
 */
EmployeeInfoDlg.showDeptSelectTree = function () {
    var cityObj = $("#citysel");
    // console.log( cityObj)
    // console.log("显示")
    var cityOffset = $("#citysel").offset();
    console.log( cityOffset)
    $("#menuContent").css({
        left: cityOffset.left + "px",
        top: cityOffset.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 显示用户详情部门选择的树
 *
 * @returns
 */
EmployeeInfoDlg.showInfoDeptSelectTree = function () {
    var cityObj = $("#citysel");
    var cityPosition = $("#citysel").position();
    console.log(cityObj);
    $("#menuContent").css({
        left: cityPosition.left+ "px",
        top: cityPosition.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 隐藏部门选择的树
 */
EmployeeInfoDlg.hideDeptSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    console.log($("#menuContent"));
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};


/**
 * 收集数据
 */
EmployeeInfoDlg.collectData = function() {
    this
    .set('ygbh')
    .set('ygxm')
    .set('ygxb')
    .set('sfz')
    .set('ygjg')
    .set('ygmz')
    .set('gzbm')
    .set('rzsj')
    .set('ygdh')
    .set('gznr')
    .set('yhkh')
    .set('zw');
}

/**
 * 提交添加
 */
EmployeeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/empinfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.Employee.table.refresh();
        EmployeeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.employeeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EmployeeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/empinfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.Employee.table.refresh();
        EmployeeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.employeeInfoData);
    ajax.start();
}
function onBodyDown(event) {
    console.log(event.target)
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
        event.target).parents("#menuContent").length > 0)) {
        EmployeeInfoDlg.hideDeptSelectTree();
    }
}


$(function() {
    var ztree = new $ZTree("treeDemo", "/dept/tree");
    console.log(ztree);
    ztree.bindOnClick(EmployeeInfoDlg.onClickDept);
    ztree.init();
    instance = ztree;
});
