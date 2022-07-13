package com.CamperLand.CT.mapper;

import com.CamperLand.CT.logic.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getList();
}
