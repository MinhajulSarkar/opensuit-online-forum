package com.open.suite.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.open.suite.domain.Comment;
import com.open.suite.domain.ThreadRegistration;
import com.open.suite.service.ThreadRegistrationHql;
import com.open.suite.service.ThreadRegistrationService;
import com.open.suite.util.DateUtil;

@Controller
@RequestMapping("/online/forum")
public class HomeController {

	
	@Autowired 
	private ThreadRegistrationHql serviceHql;
	
	@Autowired 
	private ThreadRegistrationService service;
	
	@RequestMapping()
	public String index(HttpSession session){
		/*@SuppressWarnings("unused")
		String userCode = (String) session.getAttribute("USER_CODE");
		userCode=null;*/
		return "home/index";
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public HashMap<String, Object> save(HttpSession session, @RequestBody ThreadRegistration jsonObj) {

		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			jsonObj.setUserId(1);
			jsonObj.setThreadCode(DateUtil.format(new Date(), DateUtil.CODE_DATE_FORMAT));
			jsonObj.setEntryUser("Minhaj");
			jsonObj.setEntryDate(new Date());
			service.save(jsonObj);
			map.put("message", "success");
			map.put("tag", "info");
		} catch (Exception e) {
			/*map.put("message", messageByLocalService.getErrorMessage());
			map.put("tag", "danger");*/
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public HashMap<String, Object> update(HttpSession session, @RequestBody ThreadRegistration jsonObj) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			ThreadRegistration threadRegistration=service.findThreadByCode(jsonObj.getThreadCode());
			threadRegistration.setThreadTitle(jsonObj.getThreadTitle());
			threadRegistration.setThreadDescription(jsonObj.getThreadDescription());
			threadRegistration.setUpdateUser(threadRegistration.getEntryUser());
			threadRegistration.setUpdateDate(new Date());
			service.save(threadRegistration);
			map.put("message", "Success");
			map.put("tag", "info");
		} catch (Exception e) {
			map.put("message", "Erro");
			map.put("tag", "danger");
		}
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(HttpSession session, String threadCode) {

		try {
			ThreadRegistration threadRegistration=new ThreadRegistration();
			threadRegistration.setThreadCode(threadCode);
			service.delete(threadRegistration);
		} catch (Exception e) {
			/*map.put("message", messageByLocalService.getErrorMessage());
			map.put("tag", "danger");*/
		}
		return "redirect:/online/forum";
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/all", method=RequestMethod.GET)
	public ArrayList<ThreadRegistration> fetchAll(HttpSession session) {
		return service.fetchAll();
	}
	
}
