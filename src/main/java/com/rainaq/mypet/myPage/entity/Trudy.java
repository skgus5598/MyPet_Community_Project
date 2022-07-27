package com.rainaq.mypet.myPage.entity;

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

    @Column(name = "user_id")
    private String userId;

    @Column(name = "img_name")
    private String imgName;

}
