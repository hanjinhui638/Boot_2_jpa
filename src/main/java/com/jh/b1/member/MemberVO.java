package com.jh.b1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "members") // class이름이 members이면 지정 안해줘도 됨
public class MemberVO {
	
	@Id //primaryKey
	private String id;
	//@Column(name = "password")
	private String pw;
	
	@Transient
	private String pw2; 
	
	private String name;
	private String email;
	
	

}
