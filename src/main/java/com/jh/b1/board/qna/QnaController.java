package com.jh.b1.board.qna;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Resource(name = "qnaService")
	private QnaService qnaService;

	@GetMapping("qnaWrite")
	public ModelAndView qnaWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("boardVO", new QnaVO());
		
		return mv;
	}
	
	
	@PostMapping("qnaWrite")
	public String qnaWrite(QnaVO qnaVO, List<MultipartFile> files)throws Exception{
		
		return "redirect:./qnaList";
	
		
	}
	
}
