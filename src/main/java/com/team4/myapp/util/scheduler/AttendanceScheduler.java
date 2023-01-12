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
	@Scheduled(cron = "0 0 6 * * 1-5")
	public void today_init() {
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
	
	// 매일 오후 11:59 에 이전 날의 출결, 외출 데이터를 확인하고, 총 근무시간을 통해 출결 상태를 update 한다.
	@Scheduled(cron = "0 9 14 * * 1-5")
	public void today_post() {
		 // 퇴근처리가 안된 경우 18:00 로 값을 넣는다.
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String today = sdf.format(date);
		
        try {
			attendanceService.todayPost(date, today);
			System.out.println(today + " 출석 상태 결산 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(today + " 출석 상태 결산 실패,,, ! ! !");

		}

	}

}
