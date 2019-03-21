/**
 * 浏览记录管理初始化
 */
var BrowseRecord = {
    id: "BrowseRecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
BrowseRecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '广告ID', field: 'msgId', visible: true, align: 'center', valign: 'middle'},
            {title: '用户open_id', field: 'userOpenId', visible: true, align: 'center', valign: 'middle'},
            {title: '邀请人open_id', field: 'inviteOpenId', visible: true, align: 'center', valign: 'middle'},
            {title: '点击数量', field: 'number', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
BrowseRecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        BrowseRecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加浏览记录
 */
BrowseRecord.openAddBrowseRecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加浏览记录',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/browseRecord/browseRecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看浏览记录详情
 */
BrowseRecord.openBrowseRecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '浏览记录详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/browseRecord/browseRecord_update/' + BrowseRecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除浏览记录
 */
BrowseRecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/browseRecord/delete", function (data) {
            Feng.success("删除成功!");
            BrowseRecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("browseRecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询浏览记录列表
 */
BrowseRecord.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    BrowseRecord.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = BrowseRecord.initColumn();
    var table = new BSTable(BrowseRecord.id, "/browseRecord/list", defaultColunms);
    table.setPaginationType("client");
    BrowseRecord.table = table.init();
});
