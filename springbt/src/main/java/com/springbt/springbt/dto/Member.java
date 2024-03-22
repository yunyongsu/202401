package com.springbt.springbt.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
public class Member {

	private Long id;
	private String name;
	private int age;
	private String email;
	private String memo;
	
	public Member() {}
	
	public Member(String name, int age, String email, String memo) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.memo = memo;
	}

	

}
