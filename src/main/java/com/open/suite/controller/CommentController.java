package com.open.suite.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.open.suite.domain.Comment;
import com.open.suite.domain.ThreadRegistration;
import com.open.suite.domain.User;
import com.open.suite.service.CommentHql;
import com.open.suite.service.CommentService;
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
@RequestMapping("/online/forum/comment")
public class CommentController {

	
	@Autowired 
	private CommentHql serviceHql;
	
	@Autowired 
	private ThreadRegistrationService service;
	
	@Autowired 
	private CommentService commentService;
	
	@Autowired 
	private UserService userService;
	
	String searchValue="";
	@RequestMapping()
	public String index(ModelMap modelMap, String threadCode){
		ThreadRegistration threadObj=service.findThreadByCode(threadCode);
		modelMap.put("title", "Title : "+threadObj.getThreadTitle());
		modelMap.put("description", "Description : "+threadObj.getThreadDescription());
		modelMap.put("threadCode", threadCode);
		searchValue=threadCode;
		return "comment/index";
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public HashMap<String, Object> save(@RequestBody Comment jsonObj) {

		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			if(user!=null){
			Comment comment=new Comment();
			comment.setCommentText(jsonObj.getCommentText());
			comment.setCommentCode(DateUtil.format(new Date(), DateUtil.CODE_DATE_FORMAT));
			comment.setThreadCode(searchValue);
			comment.setEntryUser("Minhaj");
			comment.setEntryDate(new Date());
			commentService.save(comment);
			map.put("message", "success");
			map.put("tag", "info");
		}else{
			map.put("message", "not permission");
			map.put("tag", "warn");
		}
		} catch (Exception e) {
			/*map.put("message", messageByLocalService.getErrorMessage());
			map.put("tag", "danger");*/
		}
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String commentCode) {

		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			if(user!=null){
			Comment comment=new Comment();
			comment.setCommentCode(commentCode);
			commentService.delete(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/online/forum/comment?threadCode="+searchValue;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value ="/all", method=RequestMethod.GET)
	public ArrayList<Comment> fetchAll() {
		return serviceHql.fetchAllByCriteria(searchValue);
	}
	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public HashMap<String, Object> update(@RequestBody Comment jsonObj) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			if (user != null) {
				Comment commentObj = commentService.findByCommentCode(jsonObj.getCommentCode());
				commentObj.setCommentText(jsonObj.getCommentText());
				commentObj.setUpdateUser(commentObj.getEntryUser());
				commentObj.setUpdateDate(new Date());
				jsonObj.setCommentCode(commentObj.getCommentCode());
				commentService.save(commentObj);
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
	
}
