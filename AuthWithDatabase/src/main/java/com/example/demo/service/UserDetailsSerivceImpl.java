package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuthUserDetail;
import com.example.demo.model.User;
import com.example.demo.respository.UserDetailsRepository;
@Service("UserDetailsService")
public class UserDetailsSerivceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsRepository  UserDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional <User> optionaluser=UserDetailsRepository.findByUsername(username);
		 optionaluser.orElseThrow(()->new  UsernameNotFoundException("Username and password worng"));
		 UserDetails userDetails=new AuthUserDetail(optionaluser.get());
		 
		 new AccountStatusUserDetailsChecker().check(userDetails);
		return userDetails;
	}

}
