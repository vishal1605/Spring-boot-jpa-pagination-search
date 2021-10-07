package com.firstboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.firstboot.beans.Users;
import com.firstboot.dao.UserDao;

public class BootFilter implements HandlerInterceptor {
	
	@Autowired(required = true)
	private UserDao dao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Pre Handle method is Calling");
		int z=0;
		HttpSession session = request.getSession();
		String email=request.getParameter("uEmail");
		List<Users> list = dao.findAll();
		for(Users u: list) {
			String email2 = u.getEmail();
			if(email.equals(email2)) {
				z=1;
			}
			
		}
		
		if(!(z==1)) {
	      return true;
		}else {
			session.removeAttribute("failedMsg");
			System.out.println("Email is alredy in used");
			response.sendRedirect("redirect:/");
			return false;
		}
			
	}
	
	

}
