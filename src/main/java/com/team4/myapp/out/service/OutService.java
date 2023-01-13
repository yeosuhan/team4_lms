package com.team4.myapp.out.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.out.dao.IOutRepository;
import com.team4.myapp.out.model.OutDto;
import com.team4.myapp.out.model.OutListDto;
import com.team4.myapp.util.date.Today;

@Service
public class OutService implements IOutService {

	@Autowired
	IOutRepository outRepository;

	public boolean selectOut(String memberId) {
		// 오늘 최신 외출 데이터 중에서 check_out 데이터가 있는지 확인한다.
		String today = Today.getToday();
		OutDto outDto = outRepository.selectLastOut(memberId, today);
		// 복귀하지 않은 경우 : 다음 외출을 막고, 복귀버튼만 보여준다.
		if (outDto != null) {
			if (outDto.getCheckOut() == null) {
				return false;
			}
		}
		return true;
	}

	// 외출 check in
	public void insertCheckIn(String memberId) {
		outRepository.insertCheckIn(memberId);
	}

	// 외출 check out
	public void updateCheckOut(String memberId) {
		String today = Today.getToday();
		// 최근의 외출을 가져온다.
		OutDto outDto = outRepository.selectLastOut(memberId, today);
		System.out.println("복귀 버튼 누름ㄴ  " + outDto);
		outRepository.updateCheckOut(outDto.getId());
	}

	// 오늘의 외출 기록, 총 시간게산
	public OutListDto getOutDetails(String memberId, String today) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		long total = 0;
		Date in = null;
		Date out = null;
		OutListDto outListDto = new OutListDto();

		// 오늘의 외출 기록 가져오기
		List<OutDto> list = outRepository.selectOutList(memberId, today);
		outListDto.setOutlist(list);

		// 총 외출 시간 계산하기
		long time = 0;
		String ot;
		for (OutDto dto : list) {
			in = format.parse(dto.getCheckIn());
			ot = dto.getCheckOut();
			if (ot == null)
				continue;
			out = format.parse(ot);

			time = (out.getTime() - in.getTime()) / 1000; // 총 몇 초 ?
			total += time;
		}
		int h = (int) (total / 3600);
		int m = (int) (total % 3600) / 60;
		int sec = (int) (total % 60);
		outListDto.setTotal(total);
		outListDto.setHours(h);
		outListDto.setMinutes(m);
		outListDto.setSeconds(sec);

		return outListDto;
	}

}
