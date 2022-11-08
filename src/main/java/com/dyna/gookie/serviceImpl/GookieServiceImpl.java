package com.dyna.gookie.serviceImpl;

import com.dyna.gookie.entity.Gookie;
import com.dyna.gookie.mapper.GookieMapper;
import com.dyna.gookie.service.GookieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GookieServiceImpl implements GookieService {

    private final GookieMapper gookieMapper;

    //TODO 국회의원 상세 정보
    @Override
    public HashMap<String, Object> detailGookie( String monaCd,String member_id){
        HashMap<String, Object> map = new HashMap<>();
        Gookie gookie = gookieMapper.detailGookie(monaCd,member_id);
        if (gookie == null){
            map.put("result", "데이터를 불러올 수 업습니다.");
        }else {
            map.put("result", gookie);
        }
        return map;
    }

    //TODO 국회의원 상세 정보
    @Override
    public List<HashMap<String, Object>> getMeetingList(){
        HashMap<String, Object> map = new HashMap<>();
        List<HashMap<String,Object>> meetingList = gookieMapper.getMeetingList();

        return meetingList;
    }

    //TODO 국회의원 상세 정보
    @Override
    public List<HashMap<String, Object>> getGookieList(String state){
        List<HashMap<String,Object>> getGookieList = gookieMapper.getGookieList();

        if("1".equals(state)){

        }
        return getGookieList;
    }

    //TODO 국회의원 상세 정보
    @Override
    public HashMap<String, Object> getGookieListState(String state){
        List<HashMap<String,Object>> getGookieList = gookieMapper.getGookieList();
        HashMap<String, Object> resultMap = new HashMap<>();
        if("1".equals(state)){
            String[] chs = {
                    "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ",
                    "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ",
                    "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ",
                    "ㅋ", "ㅌ", "ㅍ", "ㅎ"
            };
            String[] hard = {
                    "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ",
                    "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ",
                    "ㅌ", "ㅎ"
            };
            List<HashMap<String,Object>>[] list = new List[chs.length];
            for(int i = 0; i<list.length;i++){
                list[i] = new ArrayList<>();
            }

            for ( HashMap<String,Object> item : getGookieList ){
                String hgNm = (String) item.get("hg_nm");
                char firstNm = hgNm.charAt(0);
                if(firstNm >= 0xAC00) {
                    int uniVal = firstNm - 0xAC00;
                    int cho = ((uniVal - (uniVal % 28))/28)/21;
                    System.out.println(cho);
                    System.out.println(list[cho]);
                    list[cho].add(item);
                }
            }

            List<List<HashMap<String,Object>>> newList = new ArrayList<>();
            for(int i = 0; i<list.length; i++){
                if(list[i].size()>0){
                    newList.add(list[i]);
                }
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(newList.toString());
            System.out.println(newList.size());
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@");

            List<HashMap<String,Object>> chList = new ArrayList<>();
            for(List<HashMap<String,Object>> item : list){
                if(item.size()>0){
                    HashMap<String,Object> tempMap = new HashMap<>();
                    String firstPerson = (String) item.get(0).get("hg_nm");
                    String LastPerson = (String) item.get(item.size()-1).get("hg_nm");
                    tempMap.put("firstCh",firstPerson.charAt(0));
                    tempMap.put("lastCh",LastPerson.charAt(0));
                    chList.add(tempMap);
                }
            }
            resultMap.put("list",newList);
            resultMap.put("chList",chList);
            resultMap.put("chs",hard);
        }else if("2".equals(state)){
            String[] chs = {"국민의힘", "기본소득당", "더불어민주당", "무소속", "시대전환", "정의당"};
            List<HashMap<String,Object>>[] list = new List[chs.length];
            for(int i = 0; i<list.length;i++){
                list[i] = new ArrayList<>();
            }

            for(HashMap<String,Object> item : getGookieList){
                int num = Arrays.asList(chs).indexOf(item.get("poly_nm"));
                list[num].add(item);
            }
            resultMap.put("list",list);
            resultMap.put("chList",chs);

        }else if("3".equals(state)){
            Set<String> locaList = new HashSet<>();
            for(HashMap<String,Object> item : getGookieList){
                String str = (String) item.get("orig_nm");
                locaList.add(str.split(" ")[0]);
            }

            List<String> localListArr = new ArrayList<>(locaList);
            Collections.sort(localListArr);

            List<HashMap<String,Object>>[] list = new List[localListArr.size()];
            for(int i = 0; i<list.length;i++){
                list[i] = new ArrayList<>();
            }
            for(HashMap<String,Object> item : getGookieList){
                String str = (String) item.get("orig_nm");
                int num = localListArr.indexOf(str.split(" ")[0]);
                list[num].add(item);
            }
            resultMap.put("list",list);
            resultMap.put("chList",localListArr);

        }

        return resultMap;
    }

    @Override
    public List<HashMap<String, Object>> getBestCom() {
        List<HashMap<String,Object>> list = gookieMapper.getBestCom();

        return list;
    }

    @Override
    public List<HashMap<String, Object>> getMostFa() {
        return gookieMapper.getMostFa();
    }


}
