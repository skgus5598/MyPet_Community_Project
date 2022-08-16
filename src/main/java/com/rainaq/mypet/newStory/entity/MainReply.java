package com.rainaq.mypet.newStory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "main_board_reply")
public class MainReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rep_no")
    private int repNo;

    @ManyToOne
  //  @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference  // 순환참조 제거 // 외래키가 있는 곳 // 자식클래스
    @JoinColumn(name="board_id") // fk
    private MainBoard board;

    @Column(name="rep_user_id")
    private String repUserId;

    @Column(name = "rep_content")
    private String repContent;

    @Column(name = "insert_date")
    private Date insertDate;





}
