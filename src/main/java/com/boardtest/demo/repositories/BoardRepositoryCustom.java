package com.boardtest.demo.repositories;


import com.boardtest.demo.dtos.FindBoardItemDto;
import com.boardtest.demo.dtos.SearchBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    FindBoardItemDto findBoardItem(Long id);

    Page<SearchBoardDto> searchPageBoard(Pageable pageable);

}
