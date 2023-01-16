$(function() {
	
	$('.close_modal').on('click', function() {
	      $('#myModal').modal('hide');
	   });
	   
   $('#updateButton').on('click', function() {
      console.log("수정할 게시물 번호: "+$('#updateButton').val());
      location.href="/cause/update/"+$('#updateButton').attr("value");
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
			$('#updateButton').attr("value",data.causeId);
			$('#causeId').text(id);	
			$('#causeId').val(id);
			
			
			$('#deleteButton').on('click',function(){
				var check = confirm("정말 지우시겠습니까?");
				if(check){
					 console.log("삭제할 게시물 번호: "+$('#deletCause').val());
					 $('#deleteCause').attr("value",data.causeId);
					 $('#causeDelete').submit();
				} else {
					location.href="/cause/list/1";
				}
			});
			
			if(data.causeStatus == 1 || data.causeStatus == 2){
				$('#updateButton').hide();
				$('#deleteButton').hide();
			} else{
				$('#updateButton').show();
			}
			
			// 사진 띄우기
			if(data.fileSize > 0){
				let img = '<div class="small_img imgs"><img id="causeImage" src="/file/'+id+'" style="width: 100px"/></div>';
				let img_big = '<div class="big_img imgs"><img id="causeImage" src="/file/'+id+'" style="width: 400px"/></div>';
			    console.log(img);
			    $('#cd_file').empty();
				$('#cd_file').append(img);
				$('#cd_file').append(img_big);
				
				
			} else{
				$('#cd_file').text("첨부파일 없음");
			} 
			
			 // 사진 커졌다가 작아졌다 하는 기능
			$(".small_img").on("click",function(){
				$(".big_img").addClass("on");
			});
			
			$(".big_img").on("click",function(){
				$(".big_img").removeClass("on");
			})
			
		}
	});
}