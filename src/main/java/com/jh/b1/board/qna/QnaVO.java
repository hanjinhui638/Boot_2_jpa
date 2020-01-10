package com.jh.b1.board.qna;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jh.b1.board.BoardVO;

import lombok.Data;


@Entity
@Table(name = "qna")
@Data
public class QnaVO extends BoardVO{
	
															//영속성 관리
 	@OneToMany(mappedBy = "qnaVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<QnaFilesVO> qnaFilesVOs;
	
	
	private int ref;
	private int step;
	private int depth;
	
}
