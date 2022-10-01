package com.security.services;

import com.security.entities.Personne;
import com.security.entities.Role;
import com.security.entities.User;
import com.security.repositories.PersonneRepository;
import com.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    PersonneRepository persoRepo;
    @Autowired
    UserRepository userRepo;
    public List<Personne> getPersonnes(){
        return persoRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUserName(username);
        if(null == user) {
            throw new UsernameNotFoundException("No user named" + username);
        } else {
            Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
            for(Role role:user.getRoles()){
                authorities.add(new SimpleGrantedAuthority(role.getTitre()) );
            }
            return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
        }
    }
}
