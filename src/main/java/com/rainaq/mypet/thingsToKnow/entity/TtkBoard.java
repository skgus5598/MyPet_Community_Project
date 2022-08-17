package com.rainaq.mypet.thingsToKnow.entity;

import com.rainaq.mypet.common.boardCategory.BoardCategory;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert //insert시 null인 필드를 제외시킨다.
@Table(name="board_one")
public class TtkBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private int boardId;

    @OneToOne
    @JoinColumn(name="board_category_id")  // fk
    private BoardCategory category;

    @OneToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

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

    @Column(name = "insert_date")
    private Date insertDate;


}
