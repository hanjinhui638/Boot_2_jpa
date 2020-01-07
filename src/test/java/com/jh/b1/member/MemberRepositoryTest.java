package com.jh.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void test() throws Exception{
		
		//paging 처리에 사용
		
		//long count = memberRepository.count();
		//System.out.println(count); 
		//boolean check = memberRepository.existsById("iu1");
		//System.out.println(check);
	
		
	//	List<MemberVO> ar = memberRepository.findAll();
	//	for(MemberVO memberVO:ar) {
	//	System.out.println(memberVO.getId()); 			
	//	}
		
		
	//	Optional<MemberVO> opt = memberRepository.findById("iu");
		
	//	if(opt.isPresent()) {
//			MemberVO memberVO = opt.get();
//			System.out.println(memberVO.getEmail());	
//		}else {
			
	//		System.out.println("No Data");
	//	}
		
		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("iu8");
//		memberVO.setPw("iu8");
//		memberVO.setName("Rname");
		
//		memberRepository.save(memberVO);
		
		//동일한 아이디가 있으면  update 없으면 insert 
		//데이터 전부를 업데이트해야함 
		
		
		MemberVO ar = memberRepository.findByIdAndPw("iu", "iu");
		System.out.println(ar.getName());
		
		
	}

}



