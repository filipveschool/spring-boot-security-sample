package com.filip.springbootsecuritysample.security;

import com.filip.springbootsecuritysample.domain.models.security.LoginUser;
import com.filip.springbootsecuritysample.domain.models.security.Privilege;
import com.filip.springbootsecuritysample.domain.models.security.Role;
import com.filip.springbootsecuritysample.repositories.LoginUserRepository;
import com.filip.springbootsecuritysample.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//http://www.baeldung.com/role-and-privilege-for-spring-security-registration
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginUserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MessageSource messageSource;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginUser user = userRepository.findByEmail(email);
        if (user == null) {
            return new User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(
                            roleRepository.findByName("ROLE_USER"))));
        }

        return new User(
                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges;
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        privileges = collection.stream().map(Privilege::getName).collect(Collectors.toList());
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = privileges.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }
}
