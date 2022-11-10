package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.dto.CongressReplyDto;
import com.dyna.gookie.mapper.CongressReplyMapper;
import com.dyna.gookie.service.CongressReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CongressReplyServiceImpl implements CongressReplyService {
    private final CongressReplyMapper congressReplyMapper;

    @Override
    public HashMap<String, Object> congressReplyList(int replyId){
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", congressReplyMapper.congressReplyList(replyId,""));
        return map;
    }

    @Override
    public HashMap<String, Object> insCongressReply(CongressReplyDto dto){
        HashMap<String, Object> map = new HashMap<>();
        int count = congressReplyMapper.insCongressReply(dto.getMemberId(), dto.getReplyId(), dto.getCongressReplyContent());
        if (count == 0){
            map.put("fail", "실패");
        }else {
            map.put("success", "성공");
        }
        return map;
    }

    @Override
    public HashMap<String, Object> updCongressReply(CongressReplyDto dto){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(dto);
        int count = congressReplyMapper.updCongressReply(dto.getCongressReplyId(), dto.getMemberId(), dto.getCongressReplyContent());
        if (count == 0){
            map.put("fail", "실패");
        }else {
            map.put("success", "성공");
        }
        return map;
    }

    @Override
    public HashMap<String, Object> delCongressReply(CongressReplyDto dto){
        HashMap<String, Object> map = new HashMap<>();
        int count = congressReplyMapper.delCongressReply(dto.getCongressReplyId(), dto.getMemberId());
        if (count == 0){
            map.put("fail", "실패");
        }else {
            map.put("success", "성공");
        }
        return map;
    }

}
