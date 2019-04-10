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
    var ajax = new $ax(Feng.ctxPath + "/employee/add", function(data){
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
    var ajax = new $ax(Feng.ctxPath + "/employee/update", function(data){
        Feng.success("修改成功!");
        window.parent.Employee.table.refresh();
        EmployeeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.employeeInfoData);
    ajax.start();
}

$(function() {

});
