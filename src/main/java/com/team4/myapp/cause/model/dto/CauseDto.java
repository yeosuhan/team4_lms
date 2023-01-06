package com.team4.myapp.cause.model.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="fileData")
public class CauseDto {
	//작성폼에서 날라온 데이터
	private String content;
	private Date attendanceDate;
	private int categoryId;
	private MultipartFile file;
//	private byte[] fileData;
//	private String fileName;
//	private long fileSize;
	private int attendanceStatus;
//	private String fileContentType;
	private int attendanceId;
	private String memberId;
}
