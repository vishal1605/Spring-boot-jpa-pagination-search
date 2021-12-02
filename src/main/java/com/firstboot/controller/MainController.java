package com.firstboot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstboot.beans.Users;
import com.firstboot.dao.UserDao;

@Controller
public class MainController {
	
	@Autowired(required = true)
	private UserDao dao;

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
    
	//Home Opening
	@GetMapping(path="/")
	public String home(Model m, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "register";
	}
	
	//User Registration form
	@PostMapping(path="/register")
	public String register(@RequestParam("uName") String name, @RequestParam("uEmail") String email
			, @RequestParam("uPassword") String password,
			@RequestParam("city") String city,@RequestParam("salary") double salary, Model m, HttpSession session) {
		Users user = new Users(name, email, password, city, salary, new Date().toString());
		Users u1=dao.save(user);
		System.out.println(u1);
		
		return "register";
	}
	
	//View All data with Pagination
	@GetMapping(path="/view/{page}")
	public String getUsers(@PathVariable("page") Integer page, HttpSession session,Model m) {
		Pageable pageable=PageRequest.of(page-1, 5);
//		System.out.println(keyword);
		Page<Users> list=(Page<Users>) dao.findAllUsers(pageable);		
		session.setAttribute("AllUsers", list);
		session.setAttribute("Pages", page);
		session.setAttribute("totalPages", list.getTotalPages());
		
		return "/welcome";
	}
	
	
	// Select one use with id take them to edit form
	@GetMapping(path="/updateform/{uId}")
	public String getUserById(@PathVariable("uId") int id, Model m) {
		Optional<Users> optional=dao.findById(id);
		Users user=optional.get();
		System.out.println(user);
		m.addAttribute("updateUser", user);
		
		return "/update";
			
	}
	
	
	//Edit and update User
	@PostMapping(path="/updated")
	public String update(@RequestParam("uName") String name, @RequestParam("uEmail") String email
			, @RequestParam("uPassword") String password,
			@RequestParam("city") String city,@RequestParam("salary") double salary, @RequestParam("id") int id) {
		Users user = new Users(id, name, email, password, city, salary, new Date().toString());
		Users u1=dao.save(user);
		System.out.println(u1);
		
		return "redirect:/view/1";
	}
	
	
	//Delete User
	@GetMapping(path="/delete/{uId}")
	public String deleteUser(@PathVariable("uId") int id) {
		dao.deleteById(id);
		return "redirect:/view/1";
	}
	
	
	//Login form
	@GetMapping(path="/loginForm")
	public String loginForm() {
		
		return "login";
		
	}
	
	
	//Login link
	@PostMapping(path="/login")
	public String login(@RequestParam("lName") String userName, @RequestParam("lPassword") String Password, Model m) {
		List<Users> list= dao.findByUserNameAndPassword(userName, Password);
		List<Users> user = dao.getOne(15);
		System.out.println(user);
		m.addAttribute("currentUser", list);
		
		return "user";
		
	}
	
	@PostMapping("/view/search")
	public String searchResult(@RequestParam("query") String keyword, @RequestParam("options") String options, Model m) {
		switch(options) {
		case "userName":
			List<Users> list = dao.searchByUserName(keyword);
			m.addAttribute("AllUsers", list);
			break;
			
		case "email":
			List<Users> list1 = dao.searchByEmail(keyword);
			m.addAttribute("AllUsers", list1);
			break;
			
		case "city":
			List<Users> list2 = dao.searchByCity(keyword);
			m.addAttribute("AllUsers", list2);
			break;
			
		default:
			System.out.println("Nothing");
		}
		
//		List<Users> list = dao.searchByKeywords(keyword);
//		System.out.println(options);
//		m.addAttribute("AllUsers", list);
		
		return "/search-result";
		
	}
	
//==============================REST Example==================================================================================
	
	
	//View All Data
//	@GetMapping(path="/view")  //produces = {"application/xml"}
////	@ResponseBody==it send body
//	public List<Users> getUsers(HttpSession session) {
//		List<Users> list=(List<Users>) dao.findAll();
//		session.setAttribute("AllUsers", list);
//		return list;
//	}
//	
//	//====Get Single User
//	@GetMapping(path="/updateform/{id}")
//	public Optional<Users> getUserById(@PathVariable("id") int id, Model m) {
//		Optional<Users> optional=dao.findById(id);
////		Users user=optional.get();
////		System.out.println(user);
////		m.addAttribute("updateUser", user);
//		return optional;
//			
//	}
//	
//	//=====Add User
//	@PostMapping(path="/adduser")
//	public Users register(@RequestBody Users user) {
//		
//		dao.save(user);
//		return user;
//	}
//	
//	//====Delete User
//	@DeleteMapping(path="/user/{uId}")
//	public String deleteUser(@PathVariable("uId") int id) {
//		Users user=dao.getById(id);
//		dao.delete(user);
//		
//		return "deleted";
//	}
//	
//	//====Update User
//	@PutMapping(path="/updateUser")
//	public Users update(@RequestBody Users u) {
//		dao.save(u);
//		return u;
//	}

}
