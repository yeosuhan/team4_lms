package com.team4.myapp.cause.model.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="fileData")
public class CauseListDto {
	private int causeId;
	private String content;
	private int categoryId;
	private String categoryString;
	private int attendanceId;

	private Date writeDate;
	private String memberId;
	private int causeStatus;
	private String causeStatusString;
	private int attendanceStatus;
	private String attendanceStatusString;
	private String memberName;
	private int submitStatus;

	private String attendanceDate;
	private byte[] fileData;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	
	
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
	
	public String categoryString(int categoryId) {
		if(categoryId == 5) {
			this.categoryString = "지하철 연착";
		} else if(categoryId == 6) {
			this.categoryString = "경조사";
		} else if(categoryId == 7) {
			this.categoryString = "병원";
		} else if(categoryId == 8) {
			this.categoryString = "공가";
		} else if(categoryId == 9) {
			this.categoryString = "기타";
		}
		return categoryString;
	}
}
