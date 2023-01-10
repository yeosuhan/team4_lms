package com.team4.myapp.cause.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CauseListDto {
	private int causeId;
	private String content;
	private int categoryId;
	private int attendanceId;
	private Date writeDate;
	private String memberId;
	private int causeStatus;
	private String causeStatusString;
	private int attendanceStatus;
	private String attendanceStatusString;
	private String memberName;
		
	public String attendanceStatus(int attendanceStatus) {
		if(attendanceStatus == 0) {
			this.attendanceStatusString = "결석";
		} else if(attendanceStatus == 2) {
			this.attendanceStatusString = "지각";
		} else if(attendanceStatus == 3) {
			this.attendanceStatusString = "조퇴";
		}
		return attendanceStatusString;
	}
	
	public String submitStatus(int causeStatus) {
		if(causeStatus == 0) {
			this.causeStatusString = "처리 대기중";
		} else if(causeStatus == 1) {
			this.causeStatusString = "허가";
		} else if(causeStatus == 2) {
			this.causeStatusString = "반려";
		}
		return causeStatusString;
	}
}
