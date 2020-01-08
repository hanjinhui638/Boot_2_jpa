package com.jh.b1.board.notice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	public List<NoticeVO> noticeList() throws Exception{
		return noticeRepository.findAllByNumDesc();
			
	}
	

}
