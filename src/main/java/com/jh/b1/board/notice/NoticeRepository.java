package com.jh.b1.board.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{

	
	public List<NoticeVO> findAllByNumDesc()throws Exception;
}
