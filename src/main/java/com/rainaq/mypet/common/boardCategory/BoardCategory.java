package com.rainaq.mypet.common.boardCategory;

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
@Table(name = "board_category")
public class BoardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="board_category_id")
    private int categoryId;

    @Column(name = "board_category_name")
    private String categoryName;

}
