package com.jh.b1.board.notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{
	//interface는 자동으로 public abstract 생성해주기때문에 생략 가능 
	
	//select * from notice where num > ? order by num desc 
	//@Query("select n from notice n where num >0 order by num desc")
	Page<NoticeVO> findByNumGreaterThan(int num, Pageable pageable)throws Exception;
														//변수명 상관 없음 , 순서 중요 service에서 0을 넣어줌 
	

}
