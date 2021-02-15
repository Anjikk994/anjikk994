package com.example.demo.service;

import java.util.Date;
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
	public static final int MAX_FAILED_ATTEMPTS = 3;
    
    private static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional <User> optionaluser=UserDetailsRepository.findByUsername(username);
		 
		 
		 optionaluser.orElseThrow(()->new  UsernameNotFoundException("Username and password worng"));
		 UserDetails userDetails=new AuthUserDetail(optionaluser.get());
		 
		 new AccountStatusUserDetailsChecker().check(userDetails);
		 
		return userDetails;
	}
	
	
	public void increaseFailedAttempts(User user) {
        int newFailAttempts = user.getFailedAttempt() + 1;
        UserDetailsRepository.updateFailedAttempts(newFailAttempts, user.getUsername());
    }
     
    public void resetFailedAttempts(String Username) {
    	UserDetailsRepository.updateFailedAttempts(0, Username);
    }
     
    public void lock(User user) {
        user.setAccountNonLocked(false);
        user.setLockTime(new Date());
         
        UserDetailsRepository.save(user);
    }


	public boolean unlockWhenTimeExpired(User user) {
		// TODO Auto-generated method stub
		return false;
	}
     
    

}
