package com.jh.b1.board.qna;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jh.b1.util.FilePathGenerator;
import com.jh.b1.util.FileSaver;

@Service
@Transactional
public class QnaService {
	
	@Autowired
	private QnaRepository qnaRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	public void QnaUpdate()throws Exception{
		qnaRepository.qnaUpdate("retitle", "recontents", 2);
		
	}
	
	
	public void QnaWrite(QnaVO qnaVO, List<MultipartFile> files) throws Exception{
			
		List<QnaFilesVO> qnaFilesVOs = null;
		
		//----file의 유무 검증 
		boolean check = false;
		
		if(files.size()>0) {
			for(MultipartFile multipartFile:files) {
				if(multipartFile.getSize() >0 ) {
					check = true;
					break;
				}
				
			}//if 끝
			
			if(check) {
				qnaFilesVOs = new ArrayList<QnaFilesVO>();
				
				for(MultipartFile multipartFile:files) {
					
					
					
				}
				
				
			}
			
			
			
		}
	
		
	}

}
