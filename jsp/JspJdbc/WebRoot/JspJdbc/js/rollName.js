//文本框输入判断
$('#bt').click(function() {
	var input;
	input = document.getElementById("InputNumber").value;
	if (input == "") {
		alert("请输入班级人数");
		$("#InputNumber").focus();
		return false;
	} else {
		if (validate() == false) {
			$("#InputNumber").focus();
			$("#InputNumber").val("");
			return false;
		}
	}
});

/**
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

// 按钮按下效果
$(document).ready(function() {
	myInit();
})

function myInit() {
	$('#navLeft li').click(function() {
		$('#navLeft li').removeClass('active');
		$(this).addClass('active');
	});
	$('#navRight li').click(function() {
		$('#navRight li').removeClass('active');
		$(this).addClass('active');
	});
	$("#dropdown li").click(function() {
		var temp = $(this).children("a").text();
		$("#dropdownTitle").html(temp);
	});
	$("#dropdownMethod li").click(function() {
		var temp = $(this).children("a").text();
		$("#dropdownMethodTitle").html(temp);
	});
}

// 获取下拉选单的值
$('.sex').click(function() {
	var val = $(this).attr('id');
	$('#selectedsex').val(val);
});