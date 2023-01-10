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

	// 초 분 시 일 월 요일
	// 매일 오전 5시에 오늘의 출결 데이터가 초기화되어 삽입된다.
	@Scheduled(cron = "0 0 5 * * 1-5")
	public void init() {
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
	
	// 매일 오전 12시(00시)에 이전 날의 출결, 외출 데이터를 확인하고, 총 근무시간을 통해 출결 상태를 update 한다.
	@Scheduled(cron = "0 0 5 * * 1-5")
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
