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
	active();
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

function active(){
	var url=location.href;
	var activeUrl="http://localhost:8080/RollNameJdbc/RollNameJdbc/";
	switch(url){
	case activeUrl+"delete.jsp":
		$('#navLeft li').removeClass('active');
		$("#navDelete").addClass('active');
		break;
	case activeUrl+"insert.jsp":
		$('#navLeft li').removeClass('active');
		$("#navInsert").addClass('active');		
		break;
	case activeUrl+"update.jsp":
		$('#navLeft li').removeClass('active');
		$("#navUpdate").addClass('active');		
		break;		
	case activeUrl+"read.jsp":
		$('#navLeft li').removeClass('active');
		$("#navRead").addClass('active');		
		break;		
	default:
		
	}
}

// 获取下拉选单的值
$('.sex').click(function() {
	var val = $(this).attr('id');
	$('#selectedsex').val(val);
});