package com.boardtest.demo.applications;


import com.boardtest.demo.exceptions.NameNotExist;
import com.boardtest.demo.models.Board;
import com.boardtest.demo.models.User;
import com.boardtest.demo.repositories.BoardRepository;
import com.boardtest.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateBoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public CreateBoardService(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }


    public String createBoard(String title, String cont, Long userId) {
        User user = userRepository.findById(userId).get();

        Board board = new Board(title, cont, user);

        boardRepository.save(board);

        return "created";
    }
}
