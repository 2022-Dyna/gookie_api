package com.dyna.gookie.controller;

import com.dyna.gookie.dto.ReplyDto;
import com.dyna.gookie.entity.Reply;
import com.dyna.gookie.service.ReplyService;
import com.dyna.gookie.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reply")
public class ReplyController {

    private final ReplyService replyService;

    //TODO 댓글 베스트 조회 일/주/월
    @GetMapping("/best")
    public HashMap<String, Object> bestReplyList(@RequestParam(value = "sort") int sort) throws ParseException {
        return replyService.bestReplyList(sort);
    }

    //TODO 국회의원 댓글 조회
        @GetMapping("/search")
    public ResponseEntity replyList(@RequestParam(value = "monaCd") String monaCd, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum
                                    ,@RequestParam(value = "sort", defaultValue = "1") int sort){
        HttpHeaders httpHeaders = new HttpHeaders();

        ReplyDto replyList = replyService.replyList(monaCd, pageNum, sort);

        Response response = new Response(200, "성공", replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    //TODO 댓글 작성
    @PostMapping("/write")
    public ResponseEntity replyWrite(HttpServletRequest request, @RequestBody Reply reply){

        HttpHeaders httpHeaders = new HttpHeaders();

        String replyList = replyService.replyWrite(request, reply);

        Response response = new Response(200, replyList, replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    //TODO 댓글 수정
    @PostMapping("/rewrite")
    public ResponseEntity replyModify(HttpServletRequest request, @RequestBody Reply reply){

        HttpHeaders httpHeaders = new HttpHeaders();

        String replyList = replyService.replyModify(request, reply);

        Response response = new Response(200, replyList, replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    //TODO 댓글 삭제
    @PostMapping("/delete")
    public ResponseEntity replyDelete(HttpServletRequest request, @RequestBody Reply reply){

        HttpHeaders httpHeaders = new HttpHeaders();

        String replyList = replyService.replyDelete(request, reply);

        Response response = new Response(200, replyList, replyList);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

}
