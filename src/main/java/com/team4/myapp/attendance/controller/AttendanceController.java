package com.team4.myapp.attendance.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.myapp.attendance.model.CalendarDto;
import com.team4.myapp.attendance.service.IAttendanceService;
import com.team4.myapp.out.model.OutListDto;
import com.team4.myapp.out.service.IOutService;

@Controller
public class AttendanceController {

	@Autowired
	IAttendanceService attendanceService;

	@Autowired
	IOutService outService;

	// 출근 처리
	@RequestMapping(value = "/attendance/checkin", method = RequestMethod.POST)
	public String checkIn(HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");
		String checkin = null;
		checkin = attendanceService.selectCheckIn(memberId);
		if (checkin == null) {
			attendanceService.updateChekIn(memberId);
			System.out.println("출석 됨!!!!");
		}

		return "redirect:/attendance/main";
	}

	// 유저의 출결 현황 조회
	@RequestMapping(value = "/attendance/main", method = RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
		String memberId = (String) session.getAttribute("memberid");
		String checkin = null;
		String checkout = null;
		// 출근 여부 확인
		checkin = attendanceService.selectCheckIn(memberId);
		if (checkin == null) {
			model.addAttribute("checkin", true);
		} else model.addAttribute("checkin", false);

		// 퇴근 여부 확인
		checkout = attendanceService.selectCheckOut(memberId);
		if (checkin != null && checkout == null)
			model.addAttribute("checkout", true);
		else {
			checkout = "있음";
			model.addAttribute("checkout", false);
		}

		// 외출 여부 확인
		boolean goOut = outService.selectOut(memberId);
		model.addAttribute("goOut", goOut);
		
		// 외출 기록 및 총 시간 정보
		OutListDto outListDto = null;
		try {
			outListDto = outService.getOutDetails(memberId);
			model.addAttribute("outListDto", outListDto);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 복귀 여부 확인
		System.out.println("goOut : " + goOut);
		System.out.println("aid : " + checkin);
		System.out.println("time : " + checkout);
		System.out.println("outListDto : " + outListDto);
		
		return "calendar/userCalendar";
	}

	// 유저의 출결 현황 조회 - 출결 데이터 json으로 반환하기 !!!! 월별로 가져오기 !!! {month}
	@ResponseBody
	@RequestMapping(value = "/attendance/list", method = RequestMethod.GET)
	public List<CalendarDto> getUserAttendanceList(HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");
		return attendanceService.selectMemberAttendance(memberId, 1);
	}

	// 퇴근 처리
	@RequestMapping(value = "/attendance/checkout", method = RequestMethod.POST)
	public String checkOut(HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");
		String checkout = null;
		checkout = attendanceService.selectCheckOut(memberId);
		if (checkout == null) {
			attendanceService.updateCheckOut(memberId);
		}

		return "redirect:/attendance/main";
	}

	// 조퇴 처리
	@RequestMapping(value = "/attendance/leave", method = RequestMethod.POST)
	public String leaveEarly(HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");

		// 출석을 하고, 퇴근하지 않은 경우에만 조퇴 가능
		String checkin = attendanceService.selectCheckIn(memberId);
		String checkout = attendanceService.selectCheckOut(memberId);

		if (checkin != null && checkout == null) {
			attendanceService.leaveEarly(memberId);
		}
		return "redirect:/attendance/main";
	}

	// 외출 처리
	@RequestMapping(value = "/attendance/out", method = RequestMethod.POST)
	public String getOut(HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");

		// 출석을 하고, 퇴근하지 않은 경우에만 외출 가능
		String checkin = attendanceService.selectCheckIn(memberId);
		String checkout = attendanceService.selectCheckOut(memberId);

		// 외출 가능 여부 조회 : 이전 외출의 복귀를 하지 않을 경우 false
		boolean goOut = outService.selectOut(memberId);
		if (goOut && checkin != null && checkout == null) {
			outService.insertCheckIn(memberId);
			System.out.println("외출 가능 ~");
		}
		return "redirect:/attendance/main";
	}

	// 복귀 처리
	@RequestMapping(value = "/attendance/comback", method = RequestMethod.POST)
	public String comback(HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");

		// 복귀 가능 여부 조회 : 이전 외출의 복귀를 하지 않을 경우 return false -> 복귀 가능
		boolean result = outService.selectOut(memberId);
		if (!result)
			outService.updateCheckOut(memberId);
		return "redirect:/attendance/main";
	}
}
