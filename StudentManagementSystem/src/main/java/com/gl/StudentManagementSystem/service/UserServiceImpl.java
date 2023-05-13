package com.gl.StudentManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.StudentManagementSystem.entity.User;
import com.gl.StudentManagementSystem.repository.UserRepository;
import com.gl.StudentManagementSystem.security.MyUserDetails;

public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User could not be found!");
		return new MyUserDetails(user);
	}

}
