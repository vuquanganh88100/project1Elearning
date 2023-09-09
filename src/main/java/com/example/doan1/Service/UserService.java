package com.example.doan1.Service;

import com.example.doan1.dto.UserDto;
import com.example.doan1.entities.UserEntity;
import com.example.doan1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String save(UserDto userDto){
        UserEntity userEntity =new UserEntity();
        userEntity.setUserEmail(userDto.getUserEmail());
        userEntity.setUserName(userDto.getUserName());
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userEntity.setPassword(encodedPassword);
        userEntity.setUserType(userDto.getUserType());
        userRepository.save(userEntity);
        return "Tao moi tai khoan thanh cong ";
    }
    public Integer getUserId(String userEmail) {
        UserEntity userEntity = userRepository.findFirstByUserEmail(userEmail);
        if (userEntity != null) {
            return userEntity.getUserId();
        }
        return null; // Handle the case when the user is not found
    }

    public List<UserEntity> findAll(){
      return   userRepository.findAll(); //=select*
    }
    public List<UserEntity> findUsersByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    public boolean isEmailAlreadyExists(String userEmail) {
        List<UserEntity> users = findUsersByEmail(userEmail);
        return !users.isEmpty(); // trả true nếu đã tồn tại userEmail
    }
}
