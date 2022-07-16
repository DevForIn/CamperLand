package com.CamperLand.CT.logic;

import com.CamperLand.CT.mapper.BoardMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Board boardDetail(int num) {
        return boardMapper.boardDetail(num);
    }
    public void boardUpdate(Board board) {
        boardMapper.boardUpdate(board);
    }
    public void boardDelete(int num) {
        boardMapper.boardDelete(num);
    }
}
