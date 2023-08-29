package com.boardtest.demo.controllers;

import com.boardtest.demo.applications.CreateBoardService;
import com.boardtest.demo.applications.DeleteBoardService;
import com.boardtest.demo.applications.GetBoardService;
import com.boardtest.demo.applications.GetUpdateBoardService;
import com.boardtest.demo.applications.SearchBoardService;
import com.boardtest.demo.applications.UpdateBoardService;
import com.boardtest.demo.dtos.CreateBoardDto;
import com.boardtest.demo.dtos.DeleteBoardDto;
import com.boardtest.demo.dtos.GetBoardItemDto;
import com.boardtest.demo.dtos.GetUpdateResponseDto;
import com.boardtest.demo.dtos.SearchBoardDto;
import com.boardtest.demo.dtos.UpdateBoardRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final CreateBoardService createBoardService;
    private final DeleteBoardService deleteBoardService;
    private final GetUpdateBoardService getUpdateBoardService;
    private final UpdateBoardService updateBoardService;
    private final GetBoardService getBoardService;
    private final SearchBoardService searchBoardService;


    public BoardController(CreateBoardService createBoardService, DeleteBoardService deleteBoardService, GetUpdateBoardService getUpdateBoardService, UpdateBoardService updateBoardService, GetBoardService getBoardService, SearchBoardService searchBoardService) {
        this.createBoardService = createBoardService;
        this.deleteBoardService = deleteBoardService;
        this.getUpdateBoardService = getUpdateBoardService;
        this.updateBoardService = updateBoardService;
        this.getBoardService = getBoardService;
        this.searchBoardService = searchBoardService;
    }

    // TODO: 게시물 목록 (페이징)
    @GetMapping
    public Page<SearchBoardDto> searchBoard(Pageable pageable){
        Page<SearchBoardDto> searchBoardDtos = searchBoardService.searchBoard(pageable);
        return searchBoardDtos;
    }

    // TODO: 게시물 + 댓글 가져오기
    @GetMapping("/{id}")
    public GetBoardItemDto getBoard(@PathVariable Long id){
        GetBoardItemDto boardResult = getBoardService.getBoard(id);
        return boardResult;
    }

    // TODO: 게시물 입력
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postBoard(@RequestBody CreateBoardDto createBoardDto) {
        String boardResult = createBoardService
                .createBoard(createBoardDto.getTitle(), createBoardDto.getCont(), createBoardDto.getUserId());
        return boardResult;
    }

    // TODO: 게시물 삭제
    @DeleteMapping
    public String deleteBoard(@RequestBody DeleteBoardDto deleteBoardDto){

        deleteBoardService
                .deleteBoard(deleteBoardDto.getBoardId() ,deleteBoardDto.getUserId());

        return "deleted";
    }

    // TODO: 게시물 수정
    @GetMapping("/update/{id}")
    public GetUpdateResponseDto getUpdateBoard(@PathVariable Long id){
        GetUpdateResponseDto result = getUpdateBoardService.getBoard(id);
        return result;
    }

    @PatchMapping("/update/{id}")
    public String updateBoard (
            @PathVariable Long id,
            @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {

        updateBoardService
                .updateBoard(id, updateBoardRequestDto.getTitle(), updateBoardRequestDto.getCont(), updateBoardRequestDto.getUserId());

        return "updated";
    }

}
