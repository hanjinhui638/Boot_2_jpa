package com.jh.b1.board.notice;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	//name은  service에서 준 이름이나 class명의 첫글자가 소문자인 이름 
	@Resource(name= "noticeService")
	private NoticeService noticeService;
	
	@GetMapping("noticeList")
	public ModelAndView noticeList()throws Exception{
		
		//model은 인터페이스이기 때문에 사용하려면 클래스(오버라이딩)를 만들어야되기 때문에 Spring에서 Model을 상속해서 만든 것을 받아서 사용 
		//ModelAndView도 받아서 사용 가능 
		
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> ar = noticeService.noticeList();
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
