package com.jh.b1.board.notice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Qualifier autowired 사용시 이름이 필요할 때 주로 사용 
@Service
@Transactional
public class NoticeService {
	
	//@Qualifier(" ")
	@Autowired
	private NoticeRepository noticeRepository;
	
	public List<NoticeVO> noticeList() throws Exception{
		return noticeRepository.findByNumGreaterThanOrderByNumDesc(0);
			
	}
	

}
