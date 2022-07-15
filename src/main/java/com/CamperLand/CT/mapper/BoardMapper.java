package com.CamperLand.CT.mapper;

import com.CamperLand.CT.logic.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getList();

    void insertBoard(@Param("board") Board board, @Param("cnt") int cnt);

    int boardCount();

    Board boardDetail(@Param("num") int num);

    void boardUpdate(@Param("board")Board board);

    void boardDelete(@Param("num")int num);
}
