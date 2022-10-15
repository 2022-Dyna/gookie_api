package com.dyna.gookie.controller;

import com.dyna.gookie.dto.ReplyDto;
import com.dyna.gookie.entity.Member;
import com.dyna.gookie.entity.Reply;
import com.dyna.gookie.service.ReplyService;
import com.dyna.gookie.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reply")
public class ReplyController {

    private final ReplyService replyService;

    //TODO 댓글 조회
    @GetMapping("/{congressId}")
    public ResponseEntity replyList(@PathVariable(value = "congressId") int congressId, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum){
        HttpHeaders httpHeaders = new HttpHeaders();

        ReplyDto replyList = replyService.replyList(congressId, pageNum);

        Response response = new Response(200, "성공", replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    //TODO 댓글 작성
    @PostMapping
    public ResponseEntity replyWrite(HttpServletRequest request, @RequestBody Reply reply){

        HttpHeaders httpHeaders = new HttpHeaders();

        String replyList = replyService.replyWrite(request, reply);

        Response response = new Response(200, replyList, replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    //TODO 댓글 작성
    @PutMapping
    public ResponseEntity replyModify(HttpServletRequest request, @RequestBody Reply reply){

        HttpHeaders httpHeaders = new HttpHeaders();

        String replyList = replyService.replyModify(request, reply);

        Response response = new Response(200, replyList, replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    //TODO 댓글 작성
    @DeleteMapping
    public ResponseEntity replyDelete(HttpServletRequest request, @RequestBody Reply reply){

        HttpHeaders httpHeaders = new HttpHeaders();

        String replyList = replyService.replyDelete(request, reply);

        Response response = new Response(200, replyList, replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

}
