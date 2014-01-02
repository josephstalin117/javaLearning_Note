$(function() {
    $("#submit").click(function() {
        if ($("#inputAccount").val() == "") {
            alert("请输入学号")
            $("#inputAccount").focus();
            return false;
        } else if ($("#inputPassword").val() == "") {
            alert("请输入密码")
            $("#inputPassword").focus();
            return false;
        } else if (!validate()) {
            return false;
        }

    });
});

/**
 * 判断是否为数字
 * @returns {Boolean}
 */
function validate() {
    var reg = new RegExp("^[0-9]*$");
    var obj = document.getElementById("inputAccount");
    if (!reg.test(obj.value)) {
        alert("帐号请输入数字!");
        $("#inputAccount").val("");
        $("#inputPassword").val("");
        $("#inputAccount").focus();
        return false;
    } else {
        return true;
    }
}
