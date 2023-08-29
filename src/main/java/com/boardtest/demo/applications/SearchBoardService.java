package com.boardtest.demo.applications;

import com.boardtest.demo.dtos.SearchBoardDto;
import com.boardtest.demo.repositories.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SearchBoardService {

    private final BoardRepository boardRepository;

    public SearchBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<SearchBoardDto> searchBoard(Pageable pageable){
        Page<SearchBoardDto> searchBoardDtos = boardRepository.searchPageBoard(pageable);

        return searchBoardDtos;
    }
}
