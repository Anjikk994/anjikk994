package com.example.demo.exception;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.service.UserDetailsSerivceImpl;
 
@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
     
    @Autowired
    private UserDetailsSerivceImpl userDetailsSerivceImpl;
     
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        User user = (User) userDetailsSerivceImpl.loadUserByUsername(username);
         
        if (user != null) {
            if (user.isEnabled() && user.isAccountNonLocked()) {
                if (user.getFailedAttempt() < UserDetailsSerivceImpl.MAX_FAILED_ATTEMPTS - 1) {
                	userDetailsSerivceImpl.increaseFailedAttempts(user);
                } else {
                	userDetailsSerivceImpl.lock(user);
                    exception = new LockedException("Your account has been locked due to 3 failed attempts."
                            + " It will be unlocked after 24 hours.");
                }
            } else if (!user.isAccountNonLocked()) {
                if (userDetailsSerivceImpl.unlockWhenTimeExpired(user)) {
                    exception = new LockedException("Your account has been unlocked. Please try to login again.");
                }
            }
             
        }
         
       
    }
 
}