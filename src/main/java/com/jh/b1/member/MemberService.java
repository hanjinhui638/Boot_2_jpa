package com.jh.b1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
			
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
	}
	
	
	public List<MemberFilesVO> memberfilesSelect(MemberVO memberVO, MemberFilesVO memberFilesVO)throws Exception{
		
		return memberFilesRepository.findById(memberVO.getId());
	}
	
	

}
