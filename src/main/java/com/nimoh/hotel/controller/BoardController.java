package com.nimoh.hotel.controller;

import com.nimoh.hotel.domain.Board;
import com.nimoh.hotel.dto.BoardDto;
import com.nimoh.hotel.dto.board.BoardDetailResponse;
import com.nimoh.hotel.dto.board.BoardRequest;
import com.nimoh.hotel.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * 게시판 컨트롤러
 * @author nimoh
 */
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    /**
     * 게시판 목록 리턴
     * @return
     */
    @GetMapping("")
    public List<Board> getList() {
        return boardService.findAll();
    }

    /**
     * 게시판 상세정보 리턴
     *
     * @param boardIdx
     * @return
     */
    @GetMapping("/{boardIdx}")
    public ResponseEntity<Optional<Board>> get(@PathVariable Long boardIdx) {
        try{
            return ResponseEntity.status(HttpStatus.OK).
                    body(boardService.findById(boardIdx));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(boardService.findById(boardIdx));
        }
    }

    /**
     * 게시글 등록
     * @param boardDto
     */
    @PostMapping("")
    public ResponseEntity<Void> save(BoardRequest boardRequest) {
        HttpStatus httpStatus;
        BoardDetailResponse result;
        try{
            result = boardService.save(boardRequest);
            httpStatus = HttpStatus.CREATED;
            System.out.println(result);
        }catch (Exception e){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }

    /**
     * 게시글 수정
     * @param board
     */
//    @PutMapping("")
//    public void update(Board board) {
//        boardService.update(board);
//    }

    /**
     * 게시글 삭제
     * @param boardIdx
     */
//    @DeleteMapping("/{boardIdx}")
//    public void delete(@PathVariable int boardIdx) {
//        boardService.delete(boardIdx);
//    }
}
