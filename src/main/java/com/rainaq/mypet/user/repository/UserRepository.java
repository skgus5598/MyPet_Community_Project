package com.rainaq.mypet.user.repository;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String > {

    boolean existsByUserNick(String userNick);
   UserEntity findAllByUserId(String userId);

}
