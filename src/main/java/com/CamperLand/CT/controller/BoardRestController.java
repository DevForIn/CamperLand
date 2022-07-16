package com.CamperLand.CT.controller;

import com.CamperLand.CT.logic.Board;
import com.CamperLand.CT.logic.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/boards")
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @GetMapping()
    public ResponseEntity<?> list(){
        List<Board> boardList = boardService.boardList();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postBoardWrite(@RequestBody Board board, BindingResult bindingResult){
        int cnt = boardService.boardCount();
        boardService.insertBoard(board,cnt);
        List<Board> boardList = boardService.boardList();

        if(bindingResult.hasErrors()) {
            FieldError error = bindingResult.getFieldError();
            if(error!=null) {
                throw new TooLongException(error);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @GetMapping("/{num}")
    public ResponseEntity<?> getBoardDetail(@PathVariable int num){
        Board board = boardService.boardDetail(num);
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    @PutMapping("/{num}")
    public ResponseEntity<?> postBoardWrite(@PathVariable int num, @RequestBody Board board){
        boardService.boardUpdate(board);
        List<Board> boardList = boardService.boardList();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @DeleteMapping("/{num}")
    public ResponseEntity<?> postBoardDelete(@PathVariable int num){
        boardService.boardDelete(num);
        List<Board> boardList = boardService.boardList();
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    //    @GetMapping("board")
//    public String list(Model model){
//        List<Board> board = boardService.boardList();
//        model.addAttribute("board",board);
//        return "board/boardHtml";
//    }

//    @GetMapping("boardWrite")
//    public String getBoardWrite(){
//        return "board/boardWrite";
//    }

//    @PostMapping("boardWrite")
//    public String postBoardWrite(Model model, Board board){
//        int cnt = boardService.boardCount();
//        boardService.insertBoard(board,cnt);
//        List<Board> boardlist = boardService.boardList();
//        model.addAttribute("board",boardlist);
//        return "board/boardHtml";
//    }

//    @GetMapping("boardDetail")
//    public String getBoardDetail(Model model, int num){
//        Board board = boardService.boardDetail(num);
//        model.addAttribute("board",board);
//        return "board/boardDetail";
//    }

//    @GetMapping("boardUpdate")
//    public String getBoardWrite(Model model,int num){
//        Board board = boardService.boardDetail(num);
//        model.addAttribute("board",board);
//        return "board/boardUpdate";
//    }

//    @PostMapping("boardUpdate")
//    public String PostBoardWrite(Model model, Board board){
//        boardService.boardUpdate(board);
//        List<Board> boardlist = boardService.boardList();
//        model.addAttribute("board",boardlist);
//        return "board/boardHtml";
//    }

//    @GetMapping("boardDelete")
//    public String getBoardDelete(Model model,int num){
//        Board board = boardService.boardDetail(num);
//        model.addAttribute("board",board);
//        return "board/boardDelete";
//    }
//
//    @PostMapping("boardDelete")
//    public String postBoardDelete(Model model,Board board){
//        boardService.boardDelete(board.getBoardRownum());
//        List<Board> boardlist = boardService.boardList();
//        model.addAttribute("board",boardlist);
//        return "board/boardHtml";
//    }
}

