package com.team4.myapp.util.scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.team4.myapp.attendance.dao.IAttendanceRepository;
import com.team4.myapp.attendance.service.IAttendanceService;
import com.team4.myapp.util.scheduler.dto.Statistics;

@Component
public class AttendanceScheduler {

	@Autowired
	IAttendanceService attendanceService;
	
	@Autowired
	IAttendanceRepository attendanceRepository;
	// 초 분 시 일 월 요일
	// 매일 오전 5시에 오늘의 출결 데이터가 초기화되어 삽입된다.
	@Scheduled(cron = "0 0 5 * * 1-5")
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
	@Scheduled(cron = "0 59 23 * * 1-5")
	public void today_post() {
		// 퇴근처리가 안된 경우 18:00 로 값을 넣는다.

		// 외출 시간 계산
		// 외출 값이 있을 경우 -> 마지막 외출의 check_out== null 이면 18:00로 update 한다.
		// 총 외출 시간을 기반으로 근무시간 계산 후 -> 결석 여부 판단
		System.out.println("오늘 출석 데이터 삽입 됨~~");

	}

	// 매월 말일 새벽12시 5분에 다음달 통계 넣어놔야됨 ex) member_id, 2023, 02, 0, 0, 0, 0


	// 월~금 새벽 12시 5분에 어제 출결을 통계에 넣어야함
	@Scheduled(cron = "0 10 14 * * 1-5")
	public void today_statistics() {
		// 오늘 날짜
		LocalDate todayLocalDate = LocalDate.now();
		// 어제 날짜
		LocalDate yesterdayLocalDate = todayLocalDate.minusDays(1);
		// 어제 날짜를 yyyy-MM-dd 형식으로 변환
		String year = yesterdayLocalDate.format(DateTimeFormatter.ofPattern("yyyy"));
		String month = yesterdayLocalDate.format(DateTimeFormatter.ofPattern("MM"));
		String yesterday = yesterdayLocalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		List<Statistics> mlist = attendanceRepository.selectStatus(yesterday);
		attendanceService.insertToday(mlist, yesterday, year, month);
	}
}
