package com.firstboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firstboot.beans.Users;

public interface UserDao extends JpaRepository<Users, Integer> {
	
	@Query(value="select * from users_details where u_id=?", nativeQuery = true) 
	public Users getUser(int id);
	
	@Query(value = "select u from Users u where u.uId =:n")
	public List<Users> getOne(@Param("n") int id);
	
	public List<Users> findByUserNameAndPassword(String username, String password); 
	
	
	//For pagination
	@Query(value="select * from users_details", nativeQuery = true)
	public Page<Users> findAllUsers(Pageable pageable);
	
	//Search function
	public List<Users> findByUserNameContaining(String keywords);
		
}
