package com.example.doan1.config;

import com.example.doan1.entities.UserEntity;
import com.example.doan1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// lâ thông tin user từ db
public class  UserDetailServiceImp implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findFirstByUserEmail(userEmail);
        if(userEntity==null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> setAuths=new ArrayList<>();
        setAuths.add(new SimpleGrantedAuthority("ROLE_"+userEntity.getUserType()));


        User user =new User(userEntity.getUserEmail(),userEntity.getPassword(),setAuths);
        return  user;
    }
}
