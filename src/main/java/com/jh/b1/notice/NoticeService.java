package com.jh.b1.notice;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	public Optional<NoticeVO> noticeSelect(NoticeVO noticeVO)throws Exception{
		 return noticeRepository.findById(noticeVO.getNum());
	}

}
