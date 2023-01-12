$(function() {

	// $('.js-check-all').on('click', function() {
	//
	// if ( $(this).prop('checked') ) {
	// $('th input[type="checkbox"]').each(function() {
	// $(this).prop('checked', true);
	// })
	// } else {
	// $('th input[type="checkbox"]').each(function() {
	// $(this).prop('checked', false);
	// })
	// }
	// });

	$('.close').on('click', function() {
		$('#myModal').modal('hide');
	});
	
	$('#updateButton').on('click', function() {
		console.log($('#updateButton').attr("name"))
		location.href="/cause/update/"+$('#updateButton').attr("name");
	})

});

function DetailList(id) {
	$.ajax({
		type : 'GET',
		url : "/cause/detail/" + id,
		dataType : "json",
		error : function() {
			console.log("통신 실패");
		},
		success : function(data) {
			console.log("통신 성공");
			console.log(data);
			console.log(data.attendanceDate);
			console.log(data.memberId);
			var date = data.attendanceDate.toString();
			date = date.substring(0, 10);
			$('#myModal').modal('show');
			$('#cd_date').text(date);
			$('#cd_name').text(data.memberName);
			$('#cd_attendance').text(data.attendanceStatusString);
			$('#cd_status').text(data.causeStatusString);
			$('#cd_content').text(data.content);
			$('#cd_category').text(data.categoryString);
			$('#updateButton').attr("name", data.causeId);

			$('.updateButton').append();

			// 사진 띄우기
			if (data.fileSize > 0) {
				let img = '<img src="/file/' + id + '"style="width: 100px"/>';
				console.log(img);
				$('#cd_file').empty();
				$('#cd_file').append(img);
				var i = true;

			} else {
				$('#cd_file').text("첨부파일 없음");
			}

			// 사진 커졌다가 작아졌다 하는 기능
			var i= true;
			$(function() {
				$('img').bind('click', function(event) {
					if(i == true){
						var $target = $(this); // $(event.target);
						$target.width($target.width() * 4); // 나누기는 축소
						i = false;
					} else if(i == false){
						var $target = $(this); // $(event.target);
						$target.width($target.width() / 4); // 나누기는 축소
						i = true;
					}
					
				});
	
			});

		}
	});

}
