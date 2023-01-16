package com.team4.myapp.cause.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.team4.myapp.attendance.dao.IAttendanceRepository;
import com.team4.myapp.cause.dao.ICauseRepository;
import com.team4.myapp.cause.model.Cause;
import com.team4.myapp.cause.model.dto.CauseDto;
import com.team4.myapp.cause.model.dto.CauseListDto;

@Service
public class CauseService implements ICauseService{
	
	@Autowired
	ICauseRepository causeRepository;
	
	@Autowired
	IAttendanceRepository attendanceRepository;
	
	//사유서 작성하기
	@Override
	@Transactional(rollbackFor= {Exception.class}, transactionManager="transactionManager")
	public void insertCause(CauseDto causeDto) {

		Cause cause = new Cause();
		int aId = 0;
		if(causeDto.getAttendanceId() == 0) {
			//DB에 먼저 attendanceId 만들기
			attendanceRepository.insertFutureAttendance(causeDto.getMemberId(), causeDto.getAttendanceDate());
			aId = attendanceRepository.selectAttendanceId(causeDto.getMemberId(), causeDto.getAttendanceDate().toString());
			cause.setAttendanceId(aId);
		} else {
			cause.setAttendanceId(causeDto.getAttendanceId());
		}
		//attendanceId가 있는 경우
		cause.setContent(causeDto.getContent());
		cause.setCategoryId(causeDto.getCategoryId());
		cause.setMemberId(causeDto.getMemberId());
		//파일이 있는 경우
		if(causeDto.getFile() != null && !causeDto.getFile().isEmpty()) {
			cause.setFileName(causeDto.getFile().getOriginalFilename());
			cause.setFileSize(causeDto.getFile().getSize());
			cause.setFileContentType(causeDto.getFile().getContentType());
			try {
				cause.setFileData(causeDto.getFile().getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		attendanceRepository.changeSubmitStatus(1, cause.getCategoryId());
		causeRepository.insertCause(cause);

	}
	
	//전체 행수 구하기
	@Override
	public int selectCauseCount(String memberId) {
		return causeRepository.selectCauseCount(memberId);
	} 
	
	@Override
	public int selectCount() {
		return causeRepository.selectCount();
	}

	//사유서 리스트 보기(학생)
	@Override
	public List<CauseListDto> selectCauseList(String memberId, int page) {
		//페이징 처리
		int start = ((page-1) * 5) +1;
		
		List<CauseListDto> list = causeRepository.selectCauseList(memberId, start, start+4);
		for(CauseListDto i : list) {
			String  s1 = i.attendanceStatus(i.getAttendanceStatus());
			String s2 = i.submitStatus(i.getCauseStatus());
			i.setAttendanceStatusString(s1);
			i.setCauseStatusString(s2);
		}
		
		return list;
	}

	//사유서 리스트 보기(관리자)
	@Override
	public List<CauseListDto> selectCauseListAdmin(int page) {
		//페이징 처리
		int start = ((page-1) * 5) +1;
		
		List<CauseListDto> list = causeRepository.selectCauseAdmin(start, start+4);
		for(CauseListDto i : list) {
			String  s1 = i.attendanceStatus(i.getAttendanceStatus());
			String s2 = i.submitStatus(i.getCauseStatus());
			i.setAttendanceStatusString(s1);
			i.setCauseStatusString(s2);
		}
		
		return list;
	}

	//사유서 자세히 보기
	@Override
	public CauseListDto selectCauseDetail(int causeId) {
		CauseListDto list = causeRepository.selectCauseDetail(causeId);
		String  s1 = list.attendanceStatus(list.getAttendanceStatus());
		String s2 = list.submitStatus(list.getCauseStatus());
		String s3 = list.categoryString(list.getCategoryId());
		list.setAttendanceStatusString(s1);
		list.setCauseStatusString(s2);
		list.setCategoryString(s3);
		
		return list;
	}
	
	//사진파일 불러오기용
	@Transactional
	public Cause selectFileDetail(int causeId) {
		CauseListDto causeDto = causeRepository.selectCauseDetail(causeId);
		Cause cause = new Cause();
		cause.setFileData(causeDto.getFileData());
		cause.setFileContentType(causeDto.getFileContentType());
		cause.setFileSize(causeDto.getFileSize());
		cause.setFileName(causeDto.getFileName());
		return cause;
	}

	//사유서 수정하기
	@Transactional
	public void updateCause(Cause cause) {
		
		if(cause.getFile() != null && !cause.getFile().isEmpty()) {
			cause.setFileName(cause.getFile().getOriginalFilename());
			cause.setFileSize(cause.getFile().getSize());
			cause.setFileContentType(cause.getFile().getContentType());
			try {
				cause.setFileData(cause.getFile().getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		causeRepository.updateCauseDetail(cause);
	}
	
	//사유서 삭제하기
	@Transactional
	public void deleteCause(int causeId) {
		causeRepository.deleteCause(causeId);
		attendanceRepository.changeSubmitStatus(0, causeId);
	}

	@Override
	public void accept(int causeId, int causeStatus) {
		causeRepository.accept(causeId, causeStatus);	
		attendanceRepository.attendanceUcc(causeId, causeStatus+1);	
	}

	@Override
	public List<Integer> getSubmitStatusNo() {
		List<Integer> submitStatusList= new ArrayList<Integer>();
		submitStatusList.add(causeRepository.getSubmitStatusNo(0));
		submitStatusList.add(causeRepository.getSubmitStatusNo(1));
		submitStatusList.add(causeRepository.getSubmitStatusNo(2));
		return submitStatusList;
	}

	@Override
	public List<CauseListDto> selectCauseListAdminDate(String date, int page) {
		//페이징 처리
				int start = ((page-1) * 5) +1;
				
				List<CauseListDto> list = causeRepository.selectCauseListAdminDate(date, start, start+4);
				for(CauseListDto i : list) {
					String  s1 = i.attendanceStatus(i.getAttendanceStatus());
					String s2 = i.submitStatus(i.getCauseStatus());
					i.setAttendanceStatusString(s1);
					i.setCauseStatusString(s2);
				}
				
				return list;
	}

	@Override
	public List<Integer> getSubmitStatusDateNo(String date) {
		List<Integer> submitStatusList= new ArrayList<Integer>();
		submitStatusList.add(causeRepository.getSubmitStatusDateNo(0, date));
		submitStatusList.add(causeRepository.getSubmitStatusDateNo(1, date));
		submitStatusList.add(causeRepository.getSubmitStatusDateNo(2, date));
		return submitStatusList;
	}

	@Override
	public int selectDateCount(String date) {
		return causeRepository.selectDateCount(date);
	}

	@Override
	public int selectByAttendanceId(int attendaceId) {
		return causeRepository.selectByAttendanceId(attendaceId);
	}

}
