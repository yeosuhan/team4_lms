$(function() {

  $('.js-check-all').on('click', function() {

  	if ( $(this).prop('checked') ) {
	  	$('th input[type="checkbox"]').each(function() {
	  		$(this).prop('checked', true);
	  	})
  	} else {
  		$('th input[type="checkbox"]').each(function() {
	  		$(this).prop('checked', false);
	  	})
  	}
  }); 
});

function DetailList(id){
	$.ajax({
		type: 'GET',
		url: "/cause/detail/"+id,
		dataType: "json",
		error: function(){
			console.log("통신 실패");
		}, 
		success: function(data){
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
			$('#causeId').text(id);	
			$('#causeId').val(id);
		}	
	});
}


