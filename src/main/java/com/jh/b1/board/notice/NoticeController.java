package com.jh.b1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeList")
	public ModelAndView noticeList()throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> ar = noticeService.noticeList();
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
