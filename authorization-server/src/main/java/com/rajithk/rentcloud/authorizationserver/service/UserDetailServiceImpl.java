package com.rajithk.rentcloud.authorizationserver.service;

import com.rajithk.rentcloud.authorizationserver.model.AuthUserDetail;
import com.rajithk.rentcloud.authorizationserver.model.User;
import com.rajithk.rentcloud.authorizationserver.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    private UserDetailRepository userDetailRepository;

    @Autowired
    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> user = userDetailRepository.findByUsername(name);

        user.orElseThrow(() -> new UsernameNotFoundException("User or psw wrong"));

        UserDetails userDetails = new AuthUserDetail(user.get());

        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;

    }
}
