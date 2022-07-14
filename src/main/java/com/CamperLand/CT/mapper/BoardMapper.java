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
}
