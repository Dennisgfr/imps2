/**
 * 初始化业主管理详情对话框
 */
var CustomInfoDlg = {
    customInfoData : {}
};

/**
 * 清除数据
 */
CustomInfoDlg.clearData = function() {
    this.customInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CustomInfoDlg.set = function(key, val) {
    this.customInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CustomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CustomInfoDlg.close = function() {
    parent.layer.close(window.parent.Custom.layerIndex);
}

/**
 * 收集数据
 */
CustomInfoDlg.collectData = function() {
    this
    .set('yzxm')
    .set('yzbh')
    .set('xb')
    .set('jg')
    .set('zjlx')
    .set('zjhm')
    .set('yzdh')
    .set('yzjulc')
    .set('yzjzfjh');
}

/**
 * 提交添加
 */
CustomInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/custom/add", function(data){
        Feng.success("添加成功!");
        window.parent.Custom.table.refresh();
        CustomInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.customInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CustomInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/custom/update", function(data){
        Feng.success("修改成功!");
        window.parent.Custom.table.refresh();
        CustomInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.customInfoData);
    ajax.start();
}

$(function() {

});
