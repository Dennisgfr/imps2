/**
 * 初始化维修记录详情对话框
 */
var FixInfoDlg = {
    fixInfoData : {}
};

/**
 * 清除数据
 */
FixInfoDlg.clearData = function() {
    this.fixInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FixInfoDlg.set = function(key, val) {
    this.fixInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FixInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
FixInfoDlg.close = function() {
    parent.layer.close(window.parent.Fix.layerIndex);
}

/**
 * 收集数据
 */
FixInfoDlg.collectData = function() {
    this
    .set('id')
    .set('fjbh')
    .set('yzxm')
    .set('yzdh')
    .set('wxxm')
    .set('wxrq')
    .set('wxrybh')
    .set('wxrxm')
    .set('yzpj')
    .set('bz');
}

/**
 * 提交添加
 */
FixInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/fix/add", function(data){
        Feng.success("添加成功!");
        window.parent.Fix.table.refresh();
        FixInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.fixInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
FixInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/fix/update", function(data){
        Feng.success("修改成功!");
        window.parent.Fix.table.refresh();
        FixInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.fixInfoData);
    ajax.start();
}

$(function() {

});
