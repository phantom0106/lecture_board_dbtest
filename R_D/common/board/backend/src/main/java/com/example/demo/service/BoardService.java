package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    public List<BoardDto> getBoardList() {
        return boardMapper.findAll();
    }

    public void registerBoard(BoardDto boardDto) {
        boardMapper.save(boardDto);
    }

    public BoardDto getBoardDetail(Long id) {        
        return boardMapper.findById(id);
    }

    public void deleteBoard(Long id) {
        boardMapper.delete(id);
    }

    @Transactional // ★매우 중요: 요리하다 사고 나면 없던 일로 돌리는 마법 (트랜잭션)
    public void updateBoard(BoardDto boardDto) {
        // 1. (선택) 비즈니스 로직: "제목이 비어있으면 안 돼!" 같은 검사
        if (boardDto.getTitle() == null || boardDto.getTitle().isEmpty()) {
            throw new RuntimeException("제목이 없으면 수정할 수 없어요!");
        }

        boardMapper.update(boardDto);
    }
}