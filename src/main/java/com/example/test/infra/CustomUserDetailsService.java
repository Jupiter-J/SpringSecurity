package com.example.test.infra;

import com.example.test.entity.UserEntity;
import com.example.test.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//요청받은 유저의 Id,pw와 저장된 id,pw 검증
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        //사용자를 하나 만들어서 test
        final UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUsername("entity_user");
        testUserEntity.setPassword(passwordEncoder.encode("test1pass"));
        this.userRepository.save(testUserEntity);

    }

    @Override           //사용자가 입력했던 닉네임, 비밀번호가 저장하고 반환
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final UserEntity userEntity = userRepository.findByUsername(username);

        //받아온 entity를 어떻게 userDetails로 사용하느냐
        return new User(username, userEntity.getPassword(), new ArrayList<>());
    }




}
