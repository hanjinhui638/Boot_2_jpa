package com.jh.b1.board.notice;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jh.b1.board.BoardVO;

import lombok.Data;


@Entity
@Table(name= "notice")
@Data //setter, getter, equals, hashcode
public class NoticeVO extends BoardVO{
	
	//boardVO to List 					//바로 Join하지 않고 준비하고 있다 사용할때 Join 메모리 절약 	
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFilesVO> noticeFilesVOs;


}
