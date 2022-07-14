package com.CamperLand.CT.logic;

import com.CamperLand.CT.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;


    public List<Board> boardList(){
        return boardMapper.getList();
    }
    public void insertBoard(Board board, int cnt) {
        boardMapper.insertBoard(board,cnt);
    }

    public int boardCount() {
        return boardMapper.boardCount();
    }
}
