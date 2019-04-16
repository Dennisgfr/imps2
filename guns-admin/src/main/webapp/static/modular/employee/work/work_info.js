/**
 * 初始化工作安排详情对话框
 */
var WorkInfoDlg = {
    workInfoData : {}
};

/**
 * 清除数据
 */
WorkInfoDlg.clearData = function() {
    this.workInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WorkInfoDlg.set = function(key, val) {
    this.workInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WorkInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WorkInfoDlg.close = function() {
    parent.layer.close(window.parent.Work.layerIndex);
}

/**
 * 收集数据
 */
WorkInfoDlg.collectData = function() {
    this
    .set('id')
    .set('ygbh')
    .set('ygxm')
    .set('gzrq')
    .set('gzdd')
    .set('gzrw')
    .set('jtxm');
}

/**
 * 提交添加
 */
WorkInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/work/add", function(data){
        Feng.success("添加成功!");
        window.parent.Work.table.refresh();
        WorkInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.workInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WorkInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/work/update", function(data){
        Feng.success("修改成功!");
        window.parent.Work.table.refresh();
        WorkInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.workInfoData);
    ajax.start();
}

$(function() {

});
