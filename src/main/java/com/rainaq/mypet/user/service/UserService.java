package com.rainaq.mypet.user.service;


import com.rainaq.mypet.user.entity.UserEntity;
import com.rainaq.mypet.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public boolean checkId(String userId){
      // Optional<UserEntity> user  = repo.findById(userId); // Optional은 null값을 에러없이 바로 받아준다
        return repo.existsById(userId);
    }

    public boolean checkNick(String userNick) {
        return repo.existsByUserNick(userNick);
    }

    public void registerMember(UserEntity dto) {
        repo.save(dto);
    }

    public int login(String userId, String userPwd) {

        int result;
        Optional<UserEntity> user = repo.findById(userId);

        if(!user.isEmpty()){
            if(userPwd.equals(user.get().getUserPwd())){
                result = 1; // login success
            }else{
                result = 0; //password not match
            }
        }else{
            result = 2; // No registered Id
        }
        return result;
    }
}