package com.boardtest.demo.applications;

import com.boardtest.demo.exceptions.NameNotExist;
import com.boardtest.demo.models.Board;
import com.boardtest.demo.repositories.BoardRepository;
import com.boardtest.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpdateBoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public UpdateBoardService(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    public void updateBoard(Long boardId, String title, String cont, Long userId){
        Board board = boardRepository.findById(boardId).get();

        if (board.user().id() != userId) {
            throw new NameNotExist();
        }

        board.update(title, cont);

        boardRepository.save(board);

    }
}
