/**
 * 函数对象
 * @type {{init}}
 */
var Validate = function () {
    /**
     * 初始化 jquery validation
     */
    var handlerValidation = function () {

        // 手机号码验证
        handlerInitCustomValidate();

        $("#inputForm").validate({
            errorElement:'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
    };

    /**
     * 增加自定义验证规则
     */
    var handlerInitCustomValidate = function () {
        //手机号码验证
        $.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误")

    };

    return {
        init: function () {
            handlerValidation();
        }
    }

}();

$(document).ready(function () {
    Validate.init();
});