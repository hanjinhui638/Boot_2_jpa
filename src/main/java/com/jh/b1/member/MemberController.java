package com.jh.b1.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	public String memberDelete(String id, HttpSession session)throws Exception{
		
		memberService.memberDelete(id);
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	
	//@ResponseBody view를 찾지 않고 바로 가는 것 
	@PostMapping("memberIdCheck")
	@ResponseBody
	public boolean memberIdCheck(String id)throws Exception{
		return memberService.memberIdCheck(id);
	}
	
	
	
	@GetMapping("memberUpdate")
	public void memberUpdate(HttpSession session, Model model) {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		model.addAttribute("memberVO", memberVO);
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, MultipartFile files, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberVO loginVO = (MemberVO)session.getAttribute("member");
		
		memberVO.setMemberFilesVO(loginVO.getMemberFilesVO());
		
		memberVO = memberService.memberUpdate(memberVO, files);
		
		
		System.out.println("Files:"+files.getOriginalFilename());
		
		String message = "Update Fail";
		String path = "../";
		if(memberVO !=null) {
			message = "Update Success";
			
		
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		
		return mv;
	}
	
	
	
	
	/*@GetMapping("memberFileDown")
	public ModelAndView memberfileDown(MemberFilesVO memberFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberFilesVO = memberService.memberfilesSelect(memberFilesVO);
		if(memberFilesVO !=null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");
		
			
		}else {
			mv.addObject("message", "No Image File");
			mv.addObject("path", "./memberPage");
			mv.setViewName("common/result");
			
		}
		
		return mv;
	}*/
	
	
	@GetMapping("memberJoin")
	public String memberJoin(Model model)throws Exception{
		MemberVO memberVO  = new MemberVO();
		model.addAttribute("memberVO", memberVO);
		model.addAttribute("memberVO", new MemberVO());
		return "member/memberJoin";
	}
	
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberVO memberVO2 = memberService.memberJoin(memberVO, files);
		
		String message = "Join Fail";
		String path = "../";
		
		if(memberVO2 !=null) {
			message = "Join Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path", path);
		
		return mv;
	}
	
	
	
/*	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile files)throws Exception{
								
		ModelAndView mv = new ModelAndView();
		
	if(memberService.memberJoinValidate(memberVO, bindingResult)){
		
		mv.setViewName("member/memberJoin");
		}else {		
			
			
		int result = memberService.memberJoin(memberVO, files);
		
		String message = "Join Fail";
		String path = "../";
		
		if(result>0) {
			message="Join Success";
		}
		mv.setViewName("common/result");
		mv.addObject("message",message);
		mv.addObject("path", path);
		}
		return mv;
		
	}*/
	
		
	@GetMapping("memberLogin")
	public void memberLogin(String id)throws Exception{
		
	}
	
	
//	@ModelAttribute
//	public MemberVO getMemberVO()throws Exception{
		//모든 메서드의 MemberVO를 Model에 담음 
		//MemberVO memberVO new MemberVO();
		//model.addAttribute("memberVO", memberVO);
//		return new MemberVO();
//	}
	
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		memberVO = memberService.memberLogin(memberVO);
		
		//List<MemberFilesVO> ar = memberService.memberfilesSelect(memberVO, memberFilesVO);
		
		String message ="Login Fail";
		
		if(memberVO !=null) {
			message = "Login Success";
			session.setAttribute("member", memberVO);
			//session.setAttribute("file", ar);
		}
		mv.setViewName("common/result");
		mv.addObject("message", message);
		mv.addObject("path","../");
		return mv;
	
	}
	
	@GetMapping("memberPage")
	public void memberPage()throws Exception{
			
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
}
