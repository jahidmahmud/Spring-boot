package com.sts.web.jpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sts.web.jpa.model.User;

import antlr.collections.List;

public interface UserRepo extends CrudRepository<User, Integer>{
	public java.util.List<User> findByName(String name);
	@Query("select u from User u")
	public java.util.List<User> getAllUsers();
	@Query("select u from User u where city=:c")
	public java.util.List<User> findByCity(@Param("c") String city);
	//native query
	@Query(value = "select * from user",nativeQuery = true)
	public java.util.List<User> getUsers();
}
