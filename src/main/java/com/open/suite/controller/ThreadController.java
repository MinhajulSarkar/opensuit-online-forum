package com.open.suite.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.open.suite.domain.ThreadRegistration;
import com.open.suite.domain.User;
import com.open.suite.service.ThreadRegistrationHql;
import com.open.suite.service.ThreadRegistrationService;
import com.open.suite.service.UserService;
import com.open.suite.util.DateUtil;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */

@Controller
@RequestMapping("/online/forum")
public class ThreadController {

	
	@Autowired 
	private ThreadRegistrationHql serviceHql;
	
	@Autowired 
	private ThreadRegistrationService service;
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping()
	public String index(){
		
		return "thread/index";
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public HashMap<String, Object> save(@RequestBody ThreadRegistration jsonObj) {

		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			if(user!=null){
				jsonObj.setUserEmail(user.getEmail());
				jsonObj.setThreadCode(DateUtil.format(new Date(), DateUtil.CODE_DATE_FORMAT));
				jsonObj.setEntryUser(user.getName());
				jsonObj.setEntryDate(new Date());
				service.save(jsonObj);
				map.put("message", "success");
				map.put("tag", "info");
			}else{
				map.put("message", "not permission");
				map.put("tag", "warn");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public HashMap<String, Object> update(@RequestBody ThreadRegistration jsonObj) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			if(user!=null){
			ThreadRegistration threadRegistration=service.findThreadByCode(jsonObj.getThreadCode());
			threadRegistration.setThreadTitle(jsonObj.getThreadTitle());
			threadRegistration.setThreadDescription(jsonObj.getThreadDescription());
			threadRegistration.setUpdateUser(threadRegistration.getEntryUser());
			threadRegistration.setUpdateDate(new Date());
			service.save(threadRegistration);
			map.put("message", "Success");
			map.put("tag", "info");
			}else{
				map.put("message", "not permission");
				map.put("tag", "warn");
			}
		} catch (Exception e) {
			map.put("message", "Erro");
			map.put("tag", "danger");
		}
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String threadCode) {

		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			if(user!=null){
			ThreadRegistration threadRegistration=new ThreadRegistration();
			threadRegistration.setThreadCode(threadCode);
			service.delete(threadRegistration);
			}
		} catch (Exception e) {
			/*map.put("message", messageByLocalService.getErrorMessage());
			map.put("tag", "danger");*/
		}
		return "redirect:/online/forum";
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/all", method=RequestMethod.GET)
	public ArrayList<ThreadRegistration> fetchAll() {
		return service.fetchAll();
	}
	
}
