
// $(document).ready(function() {
// 	initValues();
// })
// var year;
// var month;
// var day;

// function initValues() {
// 	year = document.getElementById("year");
// 	month = document.getElementById("month");
// 	day = document.getElementById("day");
// 	alert("heeh~");
// 	//先添加年,要判断是否为闰年
// 	for (var i = 1980; i <= 2013; i++) {
// 		year.add(new Option(i, i));
// 	}
// 	//月直接添加
// }

// $("#year").change(function(){
// 	if (year.value != "") {
// 		for (var i = 1; i <= 12; i++) {
// 			month.add(new Option(i, i));
// 		}
// 	}
// });

// $("#month").change(function(){
// 	var daysOfMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
// 	day.length = 1; //year%4==0&&year%100!=0||year%400==0


// 	if (((year.value % 100 != 0 && year.value % 4 == 0) || year.value % 400 == 0) && month.selectedIndex == 2) {
// 		for (var i = 1; i <= 29; i++) {
// 			day.add(new Option(i, i));
// 		}
// 	} else {
// 		for (var i = 0; i < daysOfMonth.length; i++) {
// 			if (month.selectedIndex - 1 == i) {
// 				for (var j = 1; j <= daysOfMonth[i]; j++) {
// 					day.add(new Option(j, j));
// 				}
// 				break;
// 			}
// 		}
// 	}
// });