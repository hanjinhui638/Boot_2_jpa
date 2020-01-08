package com.jh.b1.notice;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jh.b1.board.BoardVO;

import lombok.Data;


@Entity
@Table(name= "notice")
@Data //setter, getter, equals, hashcode
public class NoticeVO extends BoardVO{
	


}
