package com.springbt.springbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbt.springbt.dao.MemberDao;
import com.springbt.springbt.dto.Member;
import com.springbt.springbt.service.Member_Service;

@Controller
public class MyController {
	
	@Autowired
	private Member_Service service;
	
	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("members", service.list());
		return "root";
	}
	
	
	@PostMapping("/insert")
	public String insert(Model model, Member member) {
		service.insert(member);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(Model model, Long id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@PostMapping("/update_Form")
	    public String updateForm(Long id, Model model) {
	        model.addAttribute("member", service.selectById(id));
	        model.addAttribute("members", service.list());
	        return "update_Form";
	    }
	
	@PostMapping("/update")
	public String update(Model model, Member member) {
		System.out.println(member);
		service.update(member);
		return "redirect:/";
	}
	
	
	
}
