package com.rainaq.mypet.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="member_info")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_nick")
    private String userNick;

    @Column(name = "user_pwd")
    private String userPwd;

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
