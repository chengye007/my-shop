/**
 * 初始化 ICheck
 * @type {{Init}}
 */

var App = function () {
    // 私有属性
    var _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');
    var _checkboxes = $('input[type="checkbox"].minimal');

    var _idArray;

    /**
     * 初始化ICheck
     */
    var handlerInitICheck = function () {
        // 激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        // 获取顶部checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        // 获取全部checkbox
        _checkboxes = $('input[type="checkbox"].minimal')
    };


    /**
     * checkbox 的全选功能
     */
    var handlerCheckAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // console.log("click master checkbox")
            //  为true 代表未选中
            if (e.target.checked) {
                _checkboxes.iCheck("uncheck");
            }

            // 选中
            else {
                _checkboxes.iCheck("check");
            }

        })
    };

    /**
     * 批量删除
     * @param url
     */
    var handlerMultiDelete = function (url) {
        _idArray = new Array();
        // 选中的ID放入数组
        _checkboxes.each(function () {
            var _id = $(this).attr("id");
            if (_id != null
                && _id != "undefine"
                && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        /**
         * 判断用户是否选择数据项
         */
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择数据");
        }
        else {
            $("#modal-message").html("您确定删除数据项吗");
        }

        // 显示模态框
        $("#modal-default").modal("show");

        // 绑定事件
        $("#modalBtnOk").bind("click", function () {
            del();
        });

        /**
         * 删除函数  批量删除的私有函数
         */
        function del() {
            $("#modal-default").modal("hide");

            // 没有选择数据项 就关闭模态框
            if (_idArray.length == 0) {
                //.........
            }

            // 选择数据项 就进行数据项删除操作
            else {
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST" ,
                        "data": {"ids" : _idArray.toString()},
                        "datatype": "JSON",
                        "success": function (data) {

                            // 无论删除是否删除成功  这里都需要解绑定， 在绑定其他方法
                            $("#modalBtnOk").unbind("click");

                            // 删除成功
                            if (data.status === 200) {
                                // 绑定事件，确定按钮重新加载
                                $("#modalBtnOk").bind("click", function () {
                                    window.location.reload();
                                });

                            }
                            // 删除失败
                            else {
                                // 绑定事件，隐藏模态框
                                $("#modalBtnOk").bind("click", function () {
                                    $("#modal-default").modal("hide");
                                });
                            }


                            $("#modal-message").html(data.message);
                            $("#modal-default").modal("show");
                        }
                    });
                }, 500);

            }
        }
    };

    /**
     * 查看用户详细信息
     * @param url
     */
    var handlerShowDetail = function (url) {
        /**
         * 通过ajax请求的方式，将html放入模态框中
         */
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-details").modal("show");
            }
        });
    };

    /**
     * 导入文件
     */
    var handlerImportFile = function () {
        $("#modal-detail-body").html("功能正在紧张制作中");
        $("#modal-details").modal("show");
    };

    /**
     * 导出文件
     */
    var handlerOutputFile = function () {
        $("#modal-detail-body").html("功能正在紧张制作中");
        $("#modal-details").modal("show");
    };

    /**
     * 公开函数
     */
    return {
        /**
         * 初始化 dataTables
         * @constructor
         */
        Init: function () {
            handlerInitICheck();
            handlerCheckAll();
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {
            handlerMultiDelete(url);
        },

        /**
         * 显示详情
         * @param url
         */
        showDetail: function (url) {
            handlerShowDetail(url);
        },
        /**
         * 导入文件
         */
        importFile: function () {
            handlerImportFile();
        },
        /**
         * 导出文件
         */
        outputFile: function () {
            handlerOutputFile();
        }
    }
}();

/**
 * 初始化加载
 */
$(document).ready(function () {
    App.Init();
});