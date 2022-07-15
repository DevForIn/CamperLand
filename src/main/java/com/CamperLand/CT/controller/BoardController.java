package com.CamperLand.CT.controller;

import com.CamperLand.CT.logic.Board;
import com.CamperLand.CT.logic.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("board")
    public String list(Model model){
        List<Board> board = boardService.boardList();
        model.addAttribute("board",board);
        return "board/boardHtml";
    }

    @GetMapping("boardWrite")
    public String getBoardWrite(){
        return "board/boardWrite";
    }
    @PostMapping("boardWrite")
    public String postBoardWrite(Model model, Board board){
        int cnt = boardService.boardCount();
        boardService.insertBoard(board,cnt);
        List<Board> boardlist = boardService.boardList();
        model.addAttribute("board",boardlist);
        return "board/boardHtml";
    }
    @GetMapping("boardDetail")
    public String getBoardDetail(Model model, int num){
        Board board = boardService.boardDetail(num);
        model.addAttribute("board",board);
        return "board/boardDetail";
    }
    @GetMapping("boardUpdate")
    public String getBoardWrite(Model model,int num){
        Board board = boardService.boardDetail(num);
        model.addAttribute("board",board);
        return "board/boardUpdate";
    }
    @PostMapping("boardUpdate")
    public String PostBoardWrite(Model model, Board board){
        boardService.boardUpdate(board);
        List<Board> boardlist = boardService.boardList();
        model.addAttribute("board",boardlist);
        return "board/boardHtml";
    }
    @GetMapping("boardDelete")
    public String getBoardDelete(Model model,int num){
        Board board = boardService.boardDetail(num);
        model.addAttribute("board",board);
        return "board/boardDelete";
    }
    @PostMapping("boardDelete")
    public String postBoardDelete(Model model,Board board){
        boardService.boardDelete(board.getBoardRownum());
        List<Board> boardlist = boardService.boardList();
        model.addAttribute("board",boardlist);
        return "board/boardHtml";
    }
}

