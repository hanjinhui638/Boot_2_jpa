package com.jh.b1.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.jh.b1.board.qna.QnaFilesVO;
import com.jh.b1.board.qna.QnaRepository;
import com.jh.b1.board.qna.QnaService;
import com.jh.b1.board.qna.QnaVO;

@SpringBootTest
//@Transactional
class QnaReqpositoryTest {

	@Resource
	private QnaRepository qnaRepository;
	
	@Autowired
	private QnaService qnaService;
	
	@Test
	void columnTest()throws Exception{
		List<Object[]> obj = qnaRepository.qnaSelete(2);
		for(Object[] o:obj) {
			for(Object o2:o) {
			System.out.println(o2);
			}
		}
		
	}
	
	//@Test
	void updateTest()throws Exception{
		qnaService.QnaUpdate();
		
	}
	
	//@Test
	void selectTest2()throws Exception{
		QnaVO qnaVO = qnaRepository.findQnaVO(2);
		System.out.println(qnaVO.getTitle());
		System.out.println(qnaVO.getQnaFilesVOs().get(0).getFname());
		
	}
	
	//@Test
	void selectTest1()throws Exception{
		List<QnaVO> ar = qnaRepository.findQna();
		
		for(QnaVO qnaVO:ar) {
			System.out.println(qnaVO.getTitle());
			for(QnaFilesVO qnaFilesVO:qnaVO.getQnaFilesVOs()) {
				System.out.println(qnaFilesVO.getFname());
			}
		}
		
	}
	
	
	//@Test
	void selectTest()throws Exception{
		//정렬
		Pageable pageable = PageRequest.of(0, 10, Sort.by("ref").descending().and(Sort.by("step").ascending()));
				
		List<QnaVO> ar = qnaRepository.findByNumGreaterThan(0, pageable);
		for(QnaVO qnaVO:ar) {
			System.out.println(qnaVO.getTitle());
			
		}
		
	}
	
	
	//@Test
	void test() {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("qt1");
		qnaVO.setWriter("qw1");
		qnaVO.setContents("qc1");
		
		List<QnaFilesVO> ar = new ArrayList<QnaFilesVO>();
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("f1.jpg");
		qnaFilesVO.setOname("o1.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("f2.jpg");
		qnaFilesVO.setOname("o2.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaVO.setQnaFilesVOs(ar);

		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		qnaRepository.save(qnaVO);
		
		System.out.println(qnaVO.getNum());
		System.out.println(qnaVO.getTitle()); 
		
		//ref -> num 
		//autoIncrement를 사용하지 않고 증가하는 class 만들기 or save를 두번해서 update하기 
	}

}
