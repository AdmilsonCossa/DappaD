package com.lenore.dappad.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lenore.dappad.domain.User;
import com.lenore.dappad.domain.UserRoleEnum;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());
	
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("== GETTING LOGIN DETAILS! ==");
//        User user = userService.getUser("colibri");
        User user = userService.findUserByName("colibri");
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
//        Set<UserRole> userRoles = user.getUserRoles();
//        for (UserRole ur : userRoles) {
//        	roles.add(new SimpleGrantedAuthority(ur.getRole()));
//        }
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);

        return userDetails;
    }
}
