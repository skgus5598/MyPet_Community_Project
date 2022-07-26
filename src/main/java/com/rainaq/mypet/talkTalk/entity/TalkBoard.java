package com.rainaq.mypet.talkTalk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name="board_two")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert //insert시 null인 필드를 제외시킨다.
public class TalkBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private int boardId;

    @Column(name="user_id")
    private String userId;

    @Column(name="board_title")
    private String boardTitle;

    @Column(name="board_content")
    private String boardContent;

    @Column(name="img_name")
    private String imgName;

    @ColumnDefault("0")
    @Column(name="like_no")
    private int likeNo;

    @ColumnDefault("0")
    @Column(name="hit_no")
    private int hitNo;


}
