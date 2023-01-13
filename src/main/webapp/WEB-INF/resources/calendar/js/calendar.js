document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var list = [];

	console.log("!!!");
	$.ajax({
		type : 'GET', // get방식으로 통신
		url : "/attendance/list",
		dataType : "json",
		error : function() { // 통신 실패시
			console.log('통신실패!');
		},
		success : function(data) { // 통신 성공시 탭 내용담는 div를 읽어들인 값으로 채운다.
			var calendar = new FullCalendar.Calendar(calendarEl, {
				plugins : [ 'interaction', 'dayGrid' ],
				defaultDate : '2023-01-03',
				locale : "ko",
				contentHeight : 420,
				height : 400,
				editable : true,
				eventLimit : true, // allow "more" link when too many events
				events : data,
				eventClick : function(info) {
					alert('Event: ' + info.event.title);
					console.log(info.event);
					console.log(info.event.attendanceStatus);
					console.log(info.event.extendedProps.attendanceStatus);
					// location.href =
					// "/cause/write?attendanceId="+info.event.id;

				},
			});

			calendar.render();

		}
	});

});
