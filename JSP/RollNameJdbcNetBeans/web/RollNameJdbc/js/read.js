//文本框输入判断
$('#submit').click(function() {
	var input;
	input = document.getElementById("inputId").value;
	if (input == "") {
		alert("请输入学号");
		$("#inputId").focus();
		return false;
	} else {
		if (validate() == false) {
			$("#inputId").focus();
			$("#inputId").val("");
			return false;
		} else {
			$("#finder").removeClass('hide');
			$("#finder").addClass('show');
		}
	}
});
/**
 * 判断是否为数字
 * @returns {Boolean}
 */
function validate() {
	var reg = new RegExp("^[0-9]*$");
	var obj = document.getElementById("InputNumber");
	if (!reg.test(obj.value)) {
		alert("请输入数字!");
		return false;
	} else {
		return true;
	}
}
$("#testClick").click(function() {
	$("#finder").removeClass('hide');
	$("#finder").addClass('show');
});