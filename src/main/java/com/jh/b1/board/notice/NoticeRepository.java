package com.jh.b1.board.notice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{

	
	public void findAllByNumDesc()throws Exception;
}
