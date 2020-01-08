package com.jh.b1.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{
																//primaryKey의 타입
														//save의 s는 Entity type(VO)- crud에서 상속  delete ID는 String
	
	public MemberVO findByIdAndPw(String id, String pw)throws Exception;
	
	
}
