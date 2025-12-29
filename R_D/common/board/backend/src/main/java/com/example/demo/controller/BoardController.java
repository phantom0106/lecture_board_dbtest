package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@CrossOrigin(origins = "*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<BoardDto> list() {
        return boardService.getBoardList();
    }

    @PostMapping
    public void write(@RequestBody BoardDto boardDto) {
        boardService.registerBoard(boardDto);
    }

    @GetMapping("/{id}") // 주소 뒤에 붙는 번호를 id로 받겠다는 뜻!
    public BoardDto detail(@PathVariable Long id) {
        BoardDto result = boardService.getBoardDetail(id);
    
        if (result != null) {
            
        } else {
            System.out.println("⚠️ [컨트롤러] 조회 결과가 null입니다!");
        }
        
        return result;
    }

    @DeleteMapping("/{id}") // 주소창의 번호를 id로 받음
    public void delete(@PathVariable Long id) {
        boardService.deleteBoard(id); // 서비스에게 "id라는 번호표를 줄 테니 지워라"라는 약속
    }

    @PutMapping("/{id}") // "수정(PUT) 주문 들어왔습니다!"
    public void update(@PathVariable Long id, @RequestBody BoardDto boardDto) {
    // 주소창에 있던 번호(id)를 바구니에 쏙 넣어줍니다.
        boardDto.setId(id); 
        boardService.updateBoard(boardDto);
    }
}