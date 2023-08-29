package com.boardtest.demo.applications;

import com.boardtest.demo.dtos.GetUpdateResponseDto;
import com.boardtest.demo.models.Board;
import com.boardtest.demo.repositories.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetUpdateBoardService {
    private final BoardRepository boardRepository;

    public GetUpdateBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public GetUpdateResponseDto getBoard(Long id){
        Board board = boardRepository.findById(id).get();

        GetUpdateResponseDto result = new GetUpdateResponseDto(board.id(), board.title(), board.cont());

        return result;
    }

}
