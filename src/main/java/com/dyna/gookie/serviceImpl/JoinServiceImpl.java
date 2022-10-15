package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.dto.MemberJoinDto;
import com.dyna.gookie.entity.Gookie;
import com.dyna.gookie.mapper.GookieMapper;
import com.dyna.gookie.mapper.JoinMapper;
import com.dyna.gookie.service.JoinService;
import com.dyna.gookie.service.MailService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.mail.MessagingException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService {

    private final JoinMapper joinMapper;
    private final MailService mailService;
    private final GookieMapper gookieMapper;

    //TODO 아이디 중복체크
    @Override
    public HashMap<String, Object> idCheck(String memberLoginId){

        HashMap<String, Object> map = new HashMap<String, Object>();

        int id = joinMapper.idCheck(memberLoginId);

        map.put("check", id);

        if (id == 0){
            map.put("msg", "사용 가능한 아이디입니다.");
        }else{
            map.put("msg", "사용 불가능한 아이디입니다.");
        }

        return map;
    }

    //TODO 회원가입
    @Override
    public HashMap<String, Object> join(MemberJoinDto member) throws MessagingException {
        HashMap<String, Object> map = new HashMap<>();

        if (ObjectUtils.isEmpty(member.getMonaCd())){
            String pw = BCrypt.hashpw(member.getMemberLoginPw(), BCrypt.gensalt());
            member.setMemberLoginPw(pw);
        }else {
            Gookie gookie = gookieMapper.detailGookie(member.getMemberLoginId(), member.getMonaCd());
            if (gookie == null){
                map.put("result", "존재하지 않는 국회의원 입니다.");
                return map;
            }
            if (joinMapper.idCheck(gookie.getEMail()) != 0){
                map.put("result", "이미 가입 이력이 않는 국회의원 입니다.");
                return map;
            }
            String pw = mailService.createPw(member.getMemberLoginId(), gookie.getHgNm());
            member.setMemberName(gookie.getHgNm());
            member.setMemberLoginPw(BCrypt.hashpw(pw, BCrypt.gensalt()));
        }

        int result = joinMapper.join(member);

        if(result == 0){
            map.put("result", "회원가입에 실패했습니다");
        } else {
            map.put("result", "회원가입에 성공했습니다");
        }
        return map;
    }
}
