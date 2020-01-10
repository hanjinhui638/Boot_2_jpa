package com.jh.b1.board.qna;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository extends JpaRepository<QnaVO, Integer> {

	List<QnaVO> findByNumGreaterThan(int num, Pageable pageable)throws Exception;
	
	//Join을 안 써도 연관관계를 맺어놨기 때문에  자동으로 Join
	@Query("select q from QnaVO q order by q.ref desc, q.step asc")
	List <QnaVO> findQna()throws Exception;
	
	@Query("select q from QnaVO q where num= :num")
	QnaVO findQnaVO(@Param("num") int num)throws Exception;
	
	
	//clearAutomatically = true생략 가능
	@Modifying(clearAutomatically = true)
	@Query(value = "update QnaVO q set q.title= :title, q.contents= :contents where q.num= :num", nativeQuery = false)
	void qnaUpdate(@Param("title") String title, @Param("contents")String contents, @Param("num")int num)throws Exception;
	
	
	//q.writer 와 q.contents는 vo로 못 받음
	@Query("select q.writer, q.contents from QnaVO q where num=?1")
	List<Object[]> qnaSelete(int num)throws Exception;
	
}
