package com.rainaq.mypet.newStory.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "user_id") // fk
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "trudy_id") // fk
    private Trudy trudy;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "like_no")
    @ColumnDefault("0") // default value = 0
    private int likeNo;



}
