package com.rainaq.mypet.myPage.repository;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyPageRepository extends JpaRepository<Trudy, Integer> {

    List<Trudy> findAllByUser(UserEntity userId);
}
