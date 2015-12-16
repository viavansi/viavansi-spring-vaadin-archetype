package ${package}.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // TODO: load user and roles from database
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        switch (username) {
            case "user":
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                break;
            case "admin":
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
            case "rest":
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_API_CLIENT"));
                break;
            default:
                throw new UsernameNotFoundException("Username not found");
        }

        return new User(username, passwordEncoder.encode(username), grantedAuthorities);
    }
}
