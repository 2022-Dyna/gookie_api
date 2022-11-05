package com.dyna.gookie.controller;

import com.dyna.gookie.dto.CongressReplyDto;
import com.dyna.gookie.service.CongressReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/congressReply")
public class CongressReplyController {

    private final CongressReplyService congressReplyService;

    @GetMapping
    public HashMap<String, Object> congressReplyList(@RequestParam(value = "replyId") int replyId){
        return congressReplyService.congressReplyList(replyId);
    }

    @PostMapping("/write")
    public HashMap<String, Object> insCongressReply(@RequestBody CongressReplyDto dto){
        return congressReplyService.insCongressReply(dto);
    }

    @PostMapping("/rewrite")
    public HashMap<String, Object> updCongressReply(@RequestBody CongressReplyDto dto){
        return congressReplyService.updCongressReply(dto);
    }

    @PostMapping("/delete")
    public HashMap<String, Object> delCongressReply(@RequestBody CongressReplyDto dto){
        return congressReplyService.delCongressReply(dto);
    }
}
