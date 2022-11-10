package com.dyna.gookie.controller;

import com.dyna.gookie.mapper.GookieMapper;
import com.dyna.gookie.service.GookieService;
import com.dyna.gookie.utils.Response;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Document;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gookie")
public class GookieController {

    private final GookieService gookieService;
    @Autowired
    private final GookieMapper gookieMapper;

    //TODO 국희의원 상세정보
    @GetMapping("/detail")
    public ResponseEntity detailGookie(String eMail, @RequestParam(value = "monaCd") String monaCd,
                                       @RequestParam(value = "member_id") String member_id) {

        HttpHeaders httpHeaders = new HttpHeaders();
        System.out.println(member_id);
        System.out.println(member_id);
        System.out.println(member_id);
        System.out.println(member_id);
        System.out.println(member_id);

        HashMap<String, Object> map = gookieService.detailGookie(monaCd,member_id);

        map.put("mona_cd", monaCd);
        List<HashMap<String, Object>> resultMap = gookieMapper.meetingResult(map);
        List<HashMap<String, Object>> resultMap3 = gookieMapper.getPresent(map);
        HashMap<String, Object> resultMap2 = gookieMapper.getMyRate(map);
        int all = 0;
        int not = 0;
        for (HashMap<String, Object> temp : resultMap) {
            Long tempLong = (Long) temp.get("count");

            all += tempLong.intValue();
            if ("불참".equals(temp.get("result"))) {
                not = tempLong.intValue();
            }
        }
        System.out.println(all);
        System.out.println(not);
        int minus = all - not;


        double onePerc = (double) minus / (double) all * 100.0;


        int rate = resultMap2==null?0:((BigDecimal)resultMap2.get("rate")).intValue();

        map.put("meetingAtt", Math.round(onePerc));
        map.put("replyPer", rate);
        map.put("myProposal", resultMap3);

        System.out.println(map.toString());
        Response response = new Response(200, "성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity listGookie(@RequestParam(value = "state") String state) {

        HttpHeaders httpHeaders = new HttpHeaders();

        HashMap<String, Object> map = gookieService.getGookieListState(state);

        Response response = new Response(200, "성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/image")
    public ResponseEntity getConImage() {

        HttpHeaders httpHeaders = new HttpHeaders();

        Response response = new Response(200, "성공", "map");

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/bestComunication")
    public ResponseEntity bestComunication() {

        HttpHeaders httpHeaders = new HttpHeaders();

        List<HashMap<String, Object>> map = gookieService.getBestCom();

        Response response = new Response(200, "성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/getMostFa")
    public ResponseEntity getMostFa() {

        HttpHeaders httpHeaders = new HttpHeaders();

        List<HashMap<String, Object>> map = gookieService.getMostFa();

        Response response = new Response(200, "성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/getAlarm")
    public ResponseEntity getMostFa(@RequestParam HashMap<String,Object> requestParam) {

        HttpHeaders httpHeaders = new HttpHeaders();

        List<HashMap<String, Object>> map = gookieMapper.getAlarm(requestParam);

        Response response = new Response(200, "성공", map);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/insAlarm")
    public ResponseEntity insAlarm(@RequestParam HashMap<String,Object> requestParam) {

        HttpHeaders httpHeaders = new HttpHeaders();

        int num = gookieMapper.insAlarm(requestParam);

        Response response = new Response(200, "성공", num);

        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }
}
