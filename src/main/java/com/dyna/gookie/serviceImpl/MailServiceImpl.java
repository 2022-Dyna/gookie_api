package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    //TODO 메일 인증번호 전송
    @Override
    public String send(String memLoginId) throws MessagingException {
        // SimpleMailMessage
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String number = certificationNumber();
        //발신자 설정
        helper.setFrom(new InternetAddress("eodyd0313@gmail.com"));

        // 수신자 설정
        helper.setTo(memLoginId);

        // 메일 제목
        helper.setSubject("[Gookie] 인증번호 전송");

        // 메일 내용
        StringBuffer emailcontent = new StringBuffer();
        emailcontent.append("<!DOCTYPE html>");
        emailcontent.append("<html>");
        emailcontent.append("<head>");
        emailcontent.append("</head>");
        emailcontent.append("<body>");
        emailcontent.append(
                " <div"
                + "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 800px; border-top: 4px solid #000000; border-bottom: 4px solid #000000; padding: 10px 0; box-sizing: border-box; padding:0 30px;  display:flex; flex-direction:column; justify-content:space-between;  \">"
                + "      <div></div>"
                + "	<h1 style=\"margin: 0; padding:30px 5px 0; font-size: 20px; font-weight: 400; line-height:1.6em\">"
                + "		<span style=\" color:#000 \">[Gookie]</span><br>"
                + "		<span style=\" color:#000 \">구키 인증번호 발급</span><br>"
                + "		<span style=\" color:#000 \">인증번호 : " + "<b>" + number +"</b>" + "</span><br>"
                + "<br>"
                + "		<h2 style=\"width:100%; text-align:right; \">Gookie</h2>"
                + "	</h1>"
        );
        emailcontent.append("</body>");
        emailcontent.append("</html>");
        helper.setText(emailcontent.toString(), true);
        javaMailSender.send(mimeMessage);

        return number;
    }

//    //TODO 메일 인증번호 전송
//    @Override
//    public String createPw(String memLoginId) throws MessagingException {
//        // SimpleMailMessage
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//        String number = certificationNumber();
//        //발신자 설정
//        helper.setFrom(new InternetAddress("eodyd0313@gmail.com"));
//
//        // 수신자 설정
//        helper.setTo(memLoginId);
//
//        // 메일 제목
//        helper.setSubject("[Gookie] ID/PW 전송");
//
//        // 메일 내용
//        StringBuffer emailcontent = new StringBuffer();
//        emailcontent.append("<!DOCTYPE html>");
//        emailcontent.append("<html>");
//        emailcontent.append("<head>");
//        emailcontent.append("</head>");
//        emailcontent.append("<body>");
//        emailcontent.append(
//                " <div"
//                        + "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 800px; border-top: 4px solid #000000; border-bottom: 4px solid #000000; padding: 10px 0; box-sizing: border-box; padding:0 30px;  display:flex; flex-direction:column; justify-content:space-between;  \">"
//                        + "      <div></div>"
//                        + "	<h1 style=\"margin: 0; padding:30px 5px 0; font-size: 20px; font-weight: 400; line-height:1.6em\">"
//                        + "		<span style=\" color:#000 \">[Gookie]</span><br>"
//                        + "		<span style=\" color:#000 \">구키 인증번호 발급</span><br>"
//                        + "		<span style=\" color:#000 \">인증번호 : " + "<b>" + number +"</b>" + "</span><br>"
//                        + "<br>"
//                        + "		<h2 style=\"width:100%; text-align:right; \">Gookie</h2>"
//                        + "	</h1>"
//        );
//        emailcontent.append("</body>");
//        emailcontent.append("</html>");
//        helper.setText(emailcontent.toString(), true);
//        javaMailSender.send(mimeMessage);
//
//        return number;
//    }

    public static String certificationNumber(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }
}
