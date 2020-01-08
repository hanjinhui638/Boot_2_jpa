package com.jh.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jh.b1.board.notice.NoticeFilesVO;
import com.jh.b1.board.notice.NoticeRepository;
import com.jh.b1.board.notice.NoticeVO;

@SpringBootTest
@Transactional //lazy 사용하기 위해 필요 
class NoticeRepositoryTest {
	
	@Autowired
	private NoticeRepository NoticeRepository;

	@Test
	void Selecttest() {
		NoticeVO noticeVO= NoticeRepository.findById(1).get();
		System.out.println(noticeVO.getTitle());
		System.out.println(noticeVO.getWriter());
		
		for(NoticeFilesVO noticeFilesVO: noticeVO.getNoticeFilesVOs()){
			System.out.println(noticeFilesVO.getFname());
	
		}
	}

}
