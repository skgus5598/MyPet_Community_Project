package com.rainaq.mypet.newStory.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert //insert시 null인 필드를 제외시킨다.

@Table(name = "main_board")
public class MainBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonManagedReference  //순환참조 제거 // 연관관계의 부모클래스가 있는 컬럼 //
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

    @Column(name = "insert_date")
    private Date insertDate;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<MainReply> reply;


}
