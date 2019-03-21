/**
 * 初始化浏览记录详情对话框
 */
var BrowseRecordInfoDlg = {
    browseRecordInfoData : {}
};

/**
 * 清除数据
 */
BrowseRecordInfoDlg.clearData = function() {
    this.browseRecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BrowseRecordInfoDlg.set = function(key, val) {
    this.browseRecordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BrowseRecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BrowseRecordInfoDlg.close = function() {
    parent.layer.close(window.parent.BrowseRecord.layerIndex);
}

/**
 * 收集数据
 */
BrowseRecordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('msgId')
    .set('userOpenId')
    .set('inviteOpenId')
    .set('number')
    .set('createTime');
}

/**
 * 提交添加
 */
BrowseRecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/browseRecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.BrowseRecord.table.refresh();
        BrowseRecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.browseRecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BrowseRecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/browseRecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.BrowseRecord.table.refresh();
        BrowseRecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.browseRecordInfoData);
    ajax.start();
}

$(function() {

});
