package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
}
