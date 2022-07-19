package com.rainaq.mypet.trudies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "main_board")
public class MainBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int boardId;

    private String content;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "trudy_id")
    private String trudyId;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "like_no")
    private int likeNo;

}
