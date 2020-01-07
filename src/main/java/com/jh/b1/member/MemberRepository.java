package com.jh.b1.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{
																//primaryKey의 타입
	
	public MemberVO findByIdAndPw(String id, String pw)throws Exception;
	
}
