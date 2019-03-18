/**
 * Consumer管理初始化
 */
var TUser = {
    id: "TUserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TUser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: 'openId', field: 'openId', visible: true, align: 'center', valign: 'middle'},
            {title: '昵称', field: 'nickName', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'sex', visible: true, align: 'center', valign: 'middle', formatter: function (value, row, index) {
                    if(row.sex === 1){
                        return '男';
                    }else if(row.sex === 2){
                        return '女';
                    }else{
                        return '未知';
                    }
                }},
            {title: '国家', field: 'country', visible: true, align: 'center', valign: 'middle'},
            {title: '省份', field: 'province', visible: true, align: 'center', valign: 'middle'},
            {title: '城市', field: 'city', visible: true, align: 'center', valign: 'middle'},
            {title: '用户头像url', field: 'headimgurl', visible: true, align: 'center', valign: 'middle'},
            {title: '用户特权信息', field: 'privilege', visible: true, align: 'center', valign: 'middle'},
            {title: 'unionid', field: 'unionid', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TUser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TUser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加Consumer
 */
TUser.openAddTUser = function () {
    var index = layer.open({
        type: 2,
        title: '添加Consumer',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tUser/tUser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看Consumer详情
 */
TUser.openTUserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'Consumer详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/tUser_update/' + TUser.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除Consumer
 */
TUser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tUser/delete", function (data) {
            Feng.success("删除成功!");
            TUser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tUserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询Consumer列表
 */
TUser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TUser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TUser.initColumn();
    var table = new BSTable(TUser.id, "/tUser/list", defaultColunms);
    table.setPaginationType("client");
    TUser.table = table.init();
});
