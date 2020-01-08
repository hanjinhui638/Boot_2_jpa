package com.jh.b1.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	//@Column(updatable = )
	//@Column(name = "password")
	private String pw;
	
	//mapping하지 않음 
	@Transient
	private String pw2; 
	
	private String name;
	private String email;
	
	//MemberVO To MemberFilesVO
	//@OneToOne(mappedBy = "Join하는 Entity에 선언된 자기 자신의 Entity 변수명")
	@OneToOne(mappedBy = "memberVO", cascade = CascadeType.ALL)
	private MemberFilesVO memberFilesVO;
	
	

}
