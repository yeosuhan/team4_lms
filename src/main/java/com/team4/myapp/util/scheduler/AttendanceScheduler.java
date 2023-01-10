package com.team4.myapp.util.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.team4.myapp.attendance.service.IAttendanceService;

@Component
public class AttendanceScheduler {

	@Autowired
	IAttendanceService attendanceService;

	// // 초 분 시 일 월 요일
	@Scheduled(cron = "0 0 9 * * 1-5")
	public void test() {
		try {
			attendanceService.insertAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String today = sdf.format(new Date());
        
        System.out.println(today);
		System.out.println("오늘 출석 데이터 삽입 됨~~");

	}

}
