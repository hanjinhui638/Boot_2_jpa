package com.jh.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeRepositoryTest {
	
	@Autowired
	private NoticeRepository NoticeRepository;

	@Test
	void Selecttest() {
		NoticeVO noticeVO= NoticeRepository.findById(1).get();
		System.out.println(noticeVO.getTitle());
		System.out.println(noticeVO.getWriter());
	}

}
