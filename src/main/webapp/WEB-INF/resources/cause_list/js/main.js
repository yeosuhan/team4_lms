$(function() {

/*
 * $('.js-check-all').on('click', function() {
 * 
 * if ( $(this).prop('checked') ) { $('th
 * input[type="checkbox"]').each(function() { $(this).prop('checked', true); }) }
 * else { $('th input[type="checkbox"]').each(function() {
 * $(this).prop('checked', false); }) } });
 */
	
	$('.close_modal').on('click', function() {
	      $('#myModal').modal('hide');
	   });
	   
   $('#updateButton').on('click', function() {
      console.log("수정할 게시물 번호: "+$('#updateButton').val());
      location.href="/cause/update/"+$('#updateButton').attr("value");
   })
   
   $('#deleteButton').on('click',function(){
		var check = confirm("정말 지우시겠습니까?");
		if(check){
			 console.log("삭제할 게시물 번호: "+$('#deleteButton').val());
		} else {
			location.href="/cause/list/1";
		}
	})

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
			$('#deleteCause').attr("value",data.causeId);
			
			//승인상태에 따라 버튼 달라짐.
			if(data.causeStatus == 0){
				$('#updateButton').css.display = 'none';
				console.log();
			}
			
			// 사진 띄우기
			if(data.fileSize > 0){
				let img = '<img id="causeImage" src="/file/'+id+'" style="width: 100px"/>';
			    console.log(img);
			    $('#cd_file').empty();
				$('#cd_file').append(img);
				
				
			} else{
				$('#cd_file').text("첨부파일 없음");
			} 
			
			 // 사진 커졌다가 작아졌다 하는 기능
	         var i= true;
	         $(function() {
	            $('img').bind('click', function(event) {
	               if(i == true){
	                  var $target = $(this); // $(event.target);
	                  $target.width($target.width() * 4); // 곱셈 확대
	                  i = false;
	               } else if(i == false){
	                  var $target = $(this); 
	                  $target.width($target.width() / 4); // 나누기 축소
	                  i = true;
	               }
	           });
	         });
		}
	});
}