package com.jh.b1.board.notice;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jh.b1.util.Pager;



@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	//name은  service에서 준 이름이나 class명의 첫글자가 소문자인 이름 
	@Resource(name= "noticeService")
	private NoticeService noticeService;
	

	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	
	
	@GetMapping("noticeWrite")
	public ModelAndView noticeWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("boardVO", new NoticeVO());
		
		return mv;
		
	}
	
	@PostMapping("noticeWrite")
	public String noticeWrite(NoticeVO noticeVO, List<MultipartFile> files)throws Exception{
	
		
		noticeService.noticeWrite(noticeVO, files);
		return "redirect:./noticeList";
	}
	
	
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(Integer num)throws Exception{
									//mybatis는 vo jpa는 integer가 편함
		ModelAndView mv = new ModelAndView();
		Optional<NoticeVO> opt = noticeService.noticeSelect(num);
		
		if(opt.isPresent()) {
			mv.addObject("vo", opt.get());			
			mv.setViewName("board/boardSelect");
		}else {
			mv.setViewName("common/result");
			mv.addObject("message", "No Contents");
			mv.addObject("path", "./noticeList");
		}
			return mv;
	}
	
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager)throws Exception{
		//model은 인터페이스이기 때문에 사용하려면 클래스(오버라이딩)를 만들어야되기 때문에 Spring에서 Model을 상속해서 만든 것을 받아서 사용 
		//ModelAndView도 받아서 사용 가능 
			
		ModelAndView mv = new ModelAndView();
		
		//Pageable pageable2 = PageRequest.of(0, 10, Sort.Direction.ASC, "num");
		
		
		//List<NoticeVO> ar = noticeService.noticeList(pageable2);
		pager = noticeService.noticeList(pager);
		mv.addObject("list", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
