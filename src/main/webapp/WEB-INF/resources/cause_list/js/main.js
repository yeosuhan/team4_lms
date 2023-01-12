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
			$('#myModal').modal('show');
			
			$('#cd_date').text(data.attendanceDate);
			$('#cd_name').text(data.memberName);
			$('#cd_attendance').text(data.attendanceStatusString);
			$('#cd_status').text(data.causeStatusString);
			$('#cd_content').text(data.content);
			$('#cd_category').text(data.categoryString);
			
			$('.updateButton').append();
			
			
			// 사진 띄우기
			if(data.fileSize > 0){
				let img = '<img id="causeImage" src="/file/'+id+'"style="width: 100px"/>';
			    console.log(img);
			    $('#cd_file').empty();
				$('#cd_file').append(img);
				
				
			} else{
				$('#cd_file').text("첨부파일 없음");
			} 
			
			//사진 커졌다가 작아졌다 하는 기능
			$(function() {
			 	$('img').bind('click', function(event){ 
					var $target = $(this); // $(event.target);
			            $target.width($target.width()*2);  // 나누기는 축소
			            $target.height($target.height()*2);	
			            $target.unbind();
			 	});		 
			});
			
			var updatelink = '<input type="submit" class="btn btn-info" onclick="location.href=\'/cause/update/'+id+'\'; return false;" value="수정"/>';
			
			var deletelink = '<input type="submit" class="btn btn-info" onclick="location.href=\'/cause/delete\'; return false;" value="삭제"/>';
			
//			var link = '<button class="btn btn-info" onclick="location.href=\'/cause/update/'+id+'\'">수정</button>';
			console.log(updatelink);
			$('.modal-footer').append(updatelink);
			
			console.log(deletelink);
			$('#deletebutton').append(deletelink);
			
			
		}
	});
}

function deleteButton(){
	alert("정말 지우시겠습니까?");
}