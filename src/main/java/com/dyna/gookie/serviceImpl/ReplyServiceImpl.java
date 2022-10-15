package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Member;
import com.dyna.gookie.entity.Reply;
import com.dyna.gookie.service.ReplyService;
import com.dyna.gookie.dto.ReplyDto;
import com.dyna.gookie.dto.ReplyListDto;
import com.dyna.gookie.entity.Pagination;
import com.dyna.gookie.mapper.ReplyMapper;
import com.dyna.gookie.utils.MyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    //TODO 해당 국회의원에 대한 댓글 리스트
    @Override
    public ReplyDto replyList(int congressId, int pageNum){
        int count = replyMapper.replyCount(congressId);

        Pagination pagination = MyUtils.Paging(count, pageNum, 10);

        List<ReplyListDto> list = replyMapper.replyList(congressId, pagination.getOffset(), pagination.getLimit());

        return ReplyDto.builder().replyList(list).pagination(pagination).build();
    }

    //TODO 댓글작성
    @Override
    public String replyWrite(HttpServletRequest request, Reply reply){
//        HttpSession hs = request.getSession();
//        Member member = (Member) hs.getAttribute("member");
//        reply.setMemberId(member.getMemberId());
        String massage = null;
        if (replyMapper.replyWrite(reply) == 0){
            massage = "메시지 작성 실패";
        }else {
            massage = "메시지 작성 성공";
        }
        return massage;
    }

    //TODO 댓글수정
    @Override
    public String replyModify(HttpServletRequest request, Reply reply){
//        HttpSession hs = request.getSession();
//        Member member = (Member) hs.getAttribute("member");
//        reply.setMemberId(member.getMemberId());
        String massage = null;
        if (replyMapper.replyModify(reply) == 0){
            massage = "메시지 수정 실패";
        }else {
            massage = "메시지 수정 성공";
        }
        return massage;
    }

    //TODO 댓글삭제
    @Override
    public String replyDelete(HttpServletRequest request, Reply reply){
        //        HttpSession hs = request.getSession();
//        Member member = (Member) hs.getAttribute("member");
//        reply.setMemberId(member.getMemberId());
        String massage = null;
        if (replyMapper.replyDelete(reply) == 0){
            massage = "메시지 삭제 실패";
        }else {
            massage = "메시지 삭제 성공";
        }
        return massage;
    }

}
