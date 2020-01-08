package com.jh.b1.member;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jh.b1.util.FilePathGenerator;
import com.jh.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	public boolean memberIdCheck(String id)throws Exception{
		return memberRepository.existsById(id);
		
	}
	

	public MemberVO memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
	
		File file = filePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		
		memberVO.setId(memberVO.getId());
		memberVO.setPw(memberVO.getPw());
		memberVO.setName(memberVO.getName());
		memberVO.setEmail(memberVO.getEmail());
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		
		return memberRepository.save(memberVO);
		
	}
	
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
			
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
	}
	
	
//	public List<MemberFilesVO> memberfilesSelect(MemberFilesVO memberFilesVO)throws Exception{
		
//		return memberFilesRepository.findById(memberVO.getId());
	//}
	
	

}
