package com.springbt.springbt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbt.springbt.dao.MemberDao;
import com.springbt.springbt.dto.Member;

@Service
public class Member_Service {
	
	@Autowired
	private MemberDao memberdao;
	
	public List<Member> list() {
        return memberdao.selectAll();
    }
	
	public void insert(Member member) {
		memberdao.insert2(member);
	}
	
	public void delete(Long id) {
		memberdao.delete(id);
	}
	
	public void update(Member member) {
		memberdao.update(member);
	}
	
	public Member selectById(Long id) {
		return memberdao.selectById(id);
	}

}
