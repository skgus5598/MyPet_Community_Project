package com.rainaq.mypet.boardCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<BoardCategory, Integer> {

    @Query(value = "SELECT categoryName FROM BoardCategory")
    List<String> getCategoryList();

}
