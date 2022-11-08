package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.dto.*;
import com.dyna.gookie.entity.Member;
import com.dyna.gookie.entity.Pagination;
import com.dyna.gookie.mapper.MyPageMapper;
import com.dyna.gookie.service.MyPageService;
import com.dyna.gookie.utils.MyUtils;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {
    private final MyPageMapper myPageMapper;

    @Override
    public HashMap<String, Object> myPage(long memberId){
        HashMap<String, Object> map = new HashMap<>();
        Member member = myPageMapper.myPage(memberId);
        map.put("data", member);
        return map;
    }

    @Override
    public HashMap<String, Object> myReply(long memberId, String memberRole, int pageNum, int limit){
        HashMap<String, Object> map = new HashMap<>();
        if (memberRole.equals("MEMBER")){
            int count = myPageMapper.myReplyCount(memberId);
            Pagination pagination = MyUtils.Paging(count,pageNum, limit);
            List<ReplyListDto> list = myPageMapper.myReplyList(memberId, pagination.getOffset(), pagination.getLimit());
            ReplyDto dto = ReplyDto.builder().pagination(pagination).replyList(list).build();
            map.put("data", dto);
        } else {
            int count = myPageMapper.myCongressReplyCount(memberId);
            Pagination pagination = MyUtils.Paging(count, pageNum, limit);
            List<CongressReplyDto> list = myPageMapper.myCongressReplyList(memberId, pagination.getOffset(), pagination.getLimit());
            CongressReplyListDto dto = CongressReplyListDto.builder().pagination(pagination).congressReplyList(list).build();
            map.put("data", dto);
        }
        return map;
    }

    @Override
    public HashMap<String, Object> myPageUpdate(PasswordDto dto){
        HashMap<String, Object> map = new HashMap<>();
        String dbPw = myPageMapper.selectPw(dto.getMemberId());
        if (BCrypt.checkpw(dto.getMemberLoginPw(), dbPw)){
            String changePw = BCrypt.hashpw(dto.getChangePw(), BCrypt.gensalt());
            dto.setChangePw(changePw);
            myPageMapper.passWordUpdate(dto);
            map.put("message", "성공");
            map.put("error", "0");
        }else {
            map.put("message", "현재 비밀번호 불일치");
            map.put("error", "2");
        }
        return map;
    }

    @Override
    public HashMap<String, Object> myFavorites(long memberId){
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", myPageMapper.myFavorites(memberId));
        return map;
    }

    @Override
    public HashMap<String, Object> insFavorites(String memberId, String monaCd){
        HashMap<String, Object> map = new HashMap<>();
        int result = myPageMapper.insFavorites(memberId, monaCd);
        if (result == 0){
            map.put("data", "실패");
        }else {
            map.put("data", "성공");
        }
        return map;
    }

}
