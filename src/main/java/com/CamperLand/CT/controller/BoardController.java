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
    public String postBoardWrite(Board board){
        boardService.insertBoard(board);
        return "redirect:/board/boardHtml";
    }
}

