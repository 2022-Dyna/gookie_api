package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.dto.CongressReplyDto;
import com.dyna.gookie.dto.ReplyInfoDto;
import com.dyna.gookie.entity.Reply;
import com.dyna.gookie.mapper.CongressReplyMapper;
import com.dyna.gookie.service.ReplyService;
import com.dyna.gookie.dto.ReplyDto;
import com.dyna.gookie.dto.ReplyListDto;
import com.dyna.gookie.entity.Pagination;
import com.dyna.gookie.mapper.ReplyMapper;
import com.dyna.gookie.utils.MyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;


@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final CongressReplyMapper congressReplyMapper;
    private final ReplyMapper replyMapper;

    //TODO 해당 국회의원에 대한 댓글 리스트
    @Override
    public ReplyDto replyList(String monaCd, int pageNum, int sort){
        int count = replyMapper.replyCount(monaCd);

        Pagination pagination = MyUtils.Paging(count, pageNum, 10);

        List<ReplyListDto> list = replyMapper.replyList(monaCd, sort, pagination.getOffset(), pagination.getLimit());

        for (ReplyListDto r : list){
            r.setCongressReplyList(congressReplyMapper.congressReplyList(r.getReplyId()));
        }

        return ReplyDto.builder().replyList(list).pagination(pagination).build();
    }


    //TODO 베스트 댓글 작성
    @Override
    public HashMap<String, Object> bestReplyList(int sort) throws ParseException {
        HashMap<String, Object> map = new HashMap<>();
        SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");

        String startDate = null;
        String endDate = null;
        switch (sort) {
            case 1:
                startDate = String.valueOf(LocalDate.now());
                endDate = String.valueOf(LocalDate.now());
                break;
            case 2:
                Calendar calendar1 = new GregorianCalendar();
                Calendar calendar2 = new GregorianCalendar();
                calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  //현재 주 의 월요일 날짜   (일요일은 1, .. 토요일은 7)
                calendar2.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);  //현재 주 의 월요일 날짜
                calendar2.add(calendar2.DATE, 7);//   (일요일은 1, .. 토요일은 7)
                startDate = newDtFormat.format(calendar1.getTime());
                endDate = newDtFormat.format(calendar2.getTime());
                break;
            case 3:
                LocalDate first = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
                String firstDate = first.format(DateTimeFormatter.ISO_DATE);
                LocalDate last = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
                String lastDate = last.format(DateTimeFormatter.ISO_DATE);
                startDate = firstDate;
                endDate = lastDate;
                break;
        }
        List<ReplyListDto> list = replyMapper.bestReplyList(startDate, endDate);
        map.put("list", list);
        return map;
    }

    @Override
    public List<HashMap<String, Object>> myReplyList(HashMap<String, Object> paramMap) {
        int pageNum = Integer.parseInt((String)paramMap.get("pageNum"));
        int maxIdx = Integer.parseInt((String)paramMap.get("maxIdx"));
        paramMap.put("pageNum",(pageNum-1)*maxIdx);
        List<HashMap<String,Object>> list= replyMapper.myReplyList(paramMap);

        return list;
    }

    //TODO 댓글작성
    @Override
    public String replyWrite(HttpServletRequest request, Reply reply){
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
