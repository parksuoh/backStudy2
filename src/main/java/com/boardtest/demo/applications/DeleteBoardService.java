package com.boardtest.demo.applications;

import com.boardtest.demo.exceptions.BoardNotExist;
import com.boardtest.demo.exceptions.NameNotExist;
import com.boardtest.demo.models.Board;
import com.boardtest.demo.repositories.BoardRepository;
import com.boardtest.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DeleteBoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public DeleteBoardService(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    public void deleteBoard(Long boardId, Long userId){
        Board board = boardRepository.findById(boardId).get();

        if (board.user().id() != userId) {
            throw new NameNotExist();
        }

        boardRepository.delete(board);

    }

}
