package com.jh.b1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jh.b1.util.FilePathGenerator;
import com.jh.b1.util.FileSaver;



//@Qualifier autowired 사용시 이름이 필요할 때 주로 사용 
@Service
@Transactional
public class NoticeService {
	
	//@Qualifier(" ")
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Transactional
	public Page<NoticeVO> findAll(Pageable pageable){
		return noticeRepository.findAll(pageable);
	}
	
	public void noticeWrite(NoticeVO noticeVO, List<MultipartFile> files)throws Exception{
		
		List<NoticeFilesVO> noticeFilesVOs = null;
		// -----file의 유무 검증
		boolean check = false;
		
		if(files.size()>0) {
			for(MultipartFile multipartFile: files) {
				if(multipartFile.getSize() > 0) {
					check = true;
					break;							
				}
			}			
		
		
		//for 끝
		
		if(check) {
			System.out.println("asdfsdgsdgdsgds");
			noticeFilesVOs = new ArrayList<NoticeFilesVO>();
			for(MultipartFile multipartFile:files) {
				if(multipartFile.getSize()>0) {
				NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
				File file = filePathGenerator.getUseClassPathResource("board");
				String fileName = fileSaver.save(file, multipartFile);
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(multipartFile.getOriginalFilename());
				noticeFilesVOs.add(noticeFilesVO);	
				noticeFilesVO.setNoticeVO(noticeVO);
				}
			}
			
			noticeVO.setNoticeFilesVOs(noticeFilesVOs);
			
			}	
		}
		
	
		//----파일 유무 검증 
		noticeRepository.save(noticeVO);
		
	}
	
	
	
	public Optional<NoticeVO> noticeSelect(int num)throws Exception{
		
			return noticeRepository.findById(num);
	}
	
	
	public List<NoticeVO> noticeList(Pageable pageable) throws Exception{
		Page<NoticeVO> p = noticeRepository.findByNumGreaterThan(0, pageable);
		
		return p.getContent();
			
	}
	

}
