package com.rainaq.mypet.thingsToKnow.entity;

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
@Table(name="board_one")
public class TtkBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private int board_id;

    @Column(name="board_category_id")
    private int categoryId;

    @Column(name="user_id")
    private String userId;

    @Column(name="board_title")
    private String boardTitle;

    @Column(name="board_content")
    private String boardContent;

    @Column(name="img_name")
    private String imgName;

    @Column(name="like_no")
    private int likeNo;

    @Column(name="hit_no")
    private int hitNo;



}
