package com.example.demo.repository;

import com.example.demo.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper // MyBatis용 매퍼임을 선언
public interface BoardMapper {

    List<BoardDto> findAll(); // 전체 목록 조회

    void save(BoardDto boardDTO); // 저장
    
    BoardDto findById(Long id); // 특정 번호의 글 하나만 가져오는 임무 추가

    void delete(Long id); // "id라는 번호표를 줄 테니 지워라"라는 약속

    void update(BoardDto boardDto); // 바구니(DTO)에 담긴 새 내용을 전달합니다.
}