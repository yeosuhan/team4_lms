package com.team4.myapp.cause.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="fileData")
public class Cause {
	private int causeId;
	private String content;
	private int status;
	private int categoryId;
	private MultipartFile file;
	private byte[] fileData;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private int attendanceId;
	private String memberId;
	private Date writeDate;
}
