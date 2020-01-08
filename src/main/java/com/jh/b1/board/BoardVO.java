package com.jh.b1.board;

import java.sql.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

//setter, getter, equals, hashcode
@Data
@MappedSuperclass
public class BoardVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
	
}
