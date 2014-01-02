$(function() {
    $("#submit").click(function() {
        if ($("#inputSname").val() == "") {
            alert("请输入姓名");
            $("#inputSname").focus();
            return false;
        } else if ($("#inputDid").val() == "") {
            alert("请输入院号");
            $("#inputDid").focus();
        } else if ($("#inputSpid").val() == "") {
            alert("请输入专业号");
            $("#inputSpid").focus();
        } else if ($("#inputBirthday").val() == "") {
            alert("请输入出生日期");
            $("#inputBirthday").focus();
        } else if ($("#inputEnrollment").val() == "") {
            alert("请输入出生日期");
            $("#inputEnrollment").focus();
        }

    });
});


