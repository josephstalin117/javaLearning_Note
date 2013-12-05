// 按钮按下效果
$(document).ready(function() {
    myInit();
	active();
	initValues();
})

//初始化
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

function active() {
	var url = location.href;
	var activeUrl = "http://localhost:8084/RollNameJdbcNetBeans/RollNameJdbc/";
	switch (url) {
		case activeUrl + "delete.jsp":
			$('#navLeft li').removeClass('active');
			$("#navDelete").addClass('active');
			break;
		case activeUrl + "insert.jsp":
			$('#navLeft li').removeClass('active');
			$("#navInsert").addClass('active');
			break;
		case activeUrl + "update.jsp":
			$('#navLeft li').removeClass('active');
			$("#navUpdate").addClass('active');
			break;
		case activeUrl + "read.jsp":
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



var year;
var month;
var day;

function initValues() {
	year = document.getElementById("year");
	month = document.getElementById("month");
	day = document.getElementById("day");
	//先添加年,要判断是否为闰年
	for (var i = 1980; i <= 2013; i++) {
		year.add(new Option(i, i));
	}
	//月直接添加
}

$("#year").change(function(){
	if (year.value != "") {
		for (var i = 1; i <= 12; i++) {
			month.add(new Option(i, i));
		}
	}
});

$("#month").change(function(){
	var daysOfMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	day.length = 1; //year%4==0&&year%100!=0||year%400==0


	if (((year.value % 100 != 0 && year.value % 4 == 0) || year.value % 400 == 0) && month.selectedIndex == 2) {
		for (var i = 1; i <= 29; i++) {
			day.add(new Option(i, i));
		}
	} else {
		for (var i = 0; i < daysOfMonth.length; i++) {
			if (month.selectedIndex - 1 == i) {
				for (var j = 1; j <= daysOfMonth[i]; j++) {
					day.add(new Option(j, j));
				}
				break;
			}
		}
	}
});