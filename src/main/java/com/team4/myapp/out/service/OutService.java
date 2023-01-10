package com.team4.myapp.out.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.out.dao.IOutRepository;
import com.team4.myapp.out.model.OutDto;
import com.team4.myapp.util.date.Today;

@Service
public class OutService implements IOutService {

	@Autowired
	IOutRepository outRepository;

	public boolean goOut(String memberId) {
		// 오늘 최신 외출 데이터 중에서 check_out 데이터가 있는지 확인한다.
		String today = Today.getToday();
		OutDto outDto = outRepository.selectCheckOut(memberId, today);
		// 복귀하지 않은 경우 : 다음 외출을 막고, 복귀버튼만 보여준다.
		if (outDto != null) {
			if (outDto.getCheckOut() == null)
				System.out.println(today + "  ~~~  외출 불가 ! ! !  ~~ " + outDto.toString());
				return false;
		}
		System.out.println(today + " ~~  외출 가능  ~~ "  );
		// 복귀한 경우 : 다음 외출가능하므로 버튼 노춣시킨다.
		return true;
	}
}
