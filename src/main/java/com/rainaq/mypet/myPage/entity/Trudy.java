package com.rainaq.mypet.myPage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="trudy")

public class Trudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trudy_id")
    private int trudyId;

    @Column(name = "trudy_type")
    private String trudyType;

    @Column(name = "trudy_name")
    private String trudyName;

    @Column(name = "trudy_age")
    private String trudyAge;

    @Column(name = "trudy_gender")
    private String trudyGender;

    @Column(name = "trudy_intro")
    private String trudyIntro;

    @JsonBackReference // 순환참조 제거 // 자식클래스, 연관관계의 주인(외래키가 있는 곳)
    @ManyToOne(fetch = FetchType.EAGER) // Many = many, User = one // EAGER전략, 바로 가져옴
    @JoinColumn(name = "user_id")
 //   @Column(name = "user_id")
    private UserEntity userId;

    @Column(name = "img_name")
    private String imgName;

}
