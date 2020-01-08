package com.jh.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

@SpringBootTest
class MemberFilesRepositoryTest  {

	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	
	@Test
	void selectTest() {
		MemberFilesVO memberFilesVO = memberFilesRepository.findById(2).get();
		
		System.out.println(memberFilesVO.getFname());
		System.out.println(memberFilesVO.getMemberVO().getId());
		
	}
	
	
	
//	@Test
	void test() throws Exception{
		
		
//		long count = memberFilesRepository.count();
//			System.out.println(count);
	
		
//		boolean check = memberFilesRepository.existsById(1);
//			System.out.println(check);
		
		
		
//		List<MemberFilesVO> ar = memberFilesRepository.findAll();
//			for(MemberFilesVO memberFilesVO:ar) {
//				System.out.println(memberFilesVO.getFname());
//			}
		
		
		
//		Optional<MemberFilesVO> opt = memberFilesRepository.findById(1);
//		Optional<MemberFilesVO> opt2 = memberFilesRepository.findById(1);
//		MemberFilesVO memberFilesVO = opt.get();
//		MemberFilesVO memberFilesVO2 = opt2.get();
//		System.out.println(memberFilesVO == memberFilesVO2);
		
		
		
//		MemberFilesVO memberFilesVO = new MemberFilesVO();
//		memberFilesVO.setId("admin");
//		memberFilesVO.setFname("adminImage.jpg");
//		memberFilesVO.setOname("adminImage.jpg");
//		memberFilesRepository.save(memberFilesVO);
		
		
		
		//id가 admin인 파일을 조회 
		// select * from memberFiles where id = ?		
//		List<MemberFilesVO> ar= memberFilesRepository.findById("admin");
//			for(MemberFilesVO memberFilesVO:ar) {
//			System.out.println(memberFilesVO.getId());
//			System.out.println(memberFilesVO.getFname());
//			}
	
		
		
	}

}
