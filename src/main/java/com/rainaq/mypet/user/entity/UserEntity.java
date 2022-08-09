package com.rainaq.mypet.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rainaq.mypet.myPage.entity.Trudy;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="member_info")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_nick")
    private String userNick;

    @Column(name = "user_pwd")
    private String userPwd;

    @JsonManagedReference // 순환참조제거 // 부모클래스, 연관 관계 주인의 반대편
    @OneToMany(mappedBy = "user") // 'mappedBy'가 적혀있으면 연관관계의 주인이 아님(난 FK가 아니다)DB에 컬럼을 만들지 마세요
    private List<Trudy> trudyList;

}
