package com.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.dto.Lead;

@Controller
public class SearchLeadController {
	
	@Autowired
	RestClient restClient;
	
	
	//localhost:9090/search
	@RequestMapping("/search")
	public String viewSearchLeadPage() {
		return "search";
	}
	
	
	@RequestMapping("/searchById")
	public String searchById(@RequestParam("id") long id,ModelMap model) {
		Lead lead = restClient.getLeadInfo(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
}
