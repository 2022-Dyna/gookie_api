package com.dyna.gookie.controller;

import com.dyna.gookie.mapper.GookieMapper;
import com.dyna.gookie.service.GookieService;
import com.dyna.gookie.service.OpenService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/open")
public class OpenController {

    private final OpenService openService;
    private final GookieService gookieService;
    @Autowired
    private final GookieMapper gookieMapper;
    private final String key = "451d44aa30cf47b5b3d2a3eca536ec41";

    @GetMapping()
    public HashMap<String, Object> clinicInformation(@RequestParam(value = "Type", defaultValue = "json") String Type,
                                     @RequestParam(value = "pIndex", defaultValue = "1") int pIndex,
                                     @RequestParam(value = "pSize", defaultValue = "300") int pSize){
        String result = "";
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            URL url = new URL("https://open.assembly.go.kr/portal/openapi/nwvrqwxyaytdsfvhu?KEY="+key+"&Type="+Type+"&pIndex="+pIndex+"&pSize="+pSize);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);

            JSONArray nwvrqwxyaytdsfvhu = (JSONArray)jsonObject.get("nwvrqwxyaytdsfvhu");
            JSONObject row = (JSONObject)nwvrqwxyaytdsfvhu.get(1);
            JSONArray jsonList = (JSONArray)row.get("row");

            resultMap.put("gookie", jsonList);

            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/meeting")
    public HashMap<String, Object> getMeetingList(@RequestParam(value = "Type", defaultValue = "json") String Type,
                                                     @RequestParam(value = "pIndex", defaultValue = "1") int pIndex,
                                                     @RequestParam(value = "pSize", defaultValue = "1000") int pSize

                                                  ){
        String result = "";
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<HashMap<String,Object>> meetingList = gookieService.getMeetingList();
            List<HashMap<String,Object>> gookieList = gookieService.getGookieList("");
            for(HashMap<String,Object> row : meetingList){
                System.out.println(row.get("BILL_NO"));
                System.out.println(row.toString());
                URL url = new URL("https://open.assembly.go.kr/portal/openapi/nojepdqqaweusdfbi?KEY="+key+
                        "&Type="+Type+"&pIndex="+pIndex+"&pSize="+pSize+"&AGE=21"+"&BILL_ID="+row.get("BILL_NO"));

                BufferedReader bf;
//todo 가져온 각 본회의의 데이터로 gookielist의  mona_cd와 비교, 찬,반,불참을 가져와 List에 담아 저장후 insert -> 링크테이블에 299*1000개의 정보 저장
                bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(result);


                System.out.println(jsonObject.toJSONString());


            }





            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/insertTotalMeeting")
    public HashMap<String, Object> insertTotalMeeting(@RequestParam(value = "Type", defaultValue = "json") String Type,
                                                  @RequestParam(value = "pIndex", defaultValue = "1") int pIndex,
                                                  @RequestParam(value = "pSize", defaultValue = "1000") int pSize

    ){
        try{
            URL url = new URL("https://open.assembly.go.kr/portal/openapi/nbslryaradshbpbpm?KEY="+key+
                    "&Type="+Type+"&pIndex="+pIndex+"&pSize="+pSize+"&AGE=21");

            BufferedReader bf;
//todo 가져온 각 본회의의 데이터로 gookielist의  mona_cd와 비교, 찬,반,불참을 가져와 List에 담아 저장후 insert -> 링크테이블에 299*1000개의 정보 저장
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            String result = "";
            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);

            JSONArray nwvrqwxyaytdsfvhu = (JSONArray)jsonObject.get("nbslryaradshbpbpm");
            JSONObject row = (JSONObject)nwvrqwxyaytdsfvhu.get(1);
            JSONArray jsonList = (JSONArray)row.get("row");

            System.out.println(jsonObject.toJSONString());

        }catch (Exception e){

        }



        return null;
    }

    @GetMapping("/openApi")
    public HashMap<String, Object> openApi(){
        List<HashMap<String,Object>> list = gookieMapper.getMillId();
        List<HashMap<String,Object>> gookieList = gookieMapper.getGookieList();
        for(HashMap<String,Object> map : list){
            try{
                URL url = new URL("https://open.assembly.go.kr/portal/openapi/" +
                        "nojepdqqaweusdfbi?KEY=451d44aa30cf47b5b3d2a3eca536ec41&Type=json&pIndex=1&pSize=1000&AGE=21&BILL_ID=" +
                        map.get("bill_id"));

                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                String result = "";
                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(result);

                JSONArray nojepdqqaweusdfbi = (JSONArray)jsonObject.get("nojepdqqaweusdfbi");
                if(nojepdqqaweusdfbi==null){
                    continue;
                }
                JSONObject row = (JSONObject)nojepdqqaweusdfbi.get(1);
                JSONArray jsonList = (JSONArray)row.get("row");

                for(HashMap<String,Object> gookieMap : gookieList){
                    for(Object jsonObject1:jsonList){
                        HashMap<String,Object> tempMap = new HashMap<>();
                        tempMap.put("temp",jsonObject1);
                        HashMap<String,Object> tempMap2 = (HashMap<String, Object>) tempMap.get("temp");
                        System.out.println((String)tempMap2.get("HG_NM"));
                        if(gookieMap.get("hg_nm").equals((String)tempMap2.get("HG_NM"))){
                            HashMap<String,Object> paramMap = new HashMap<>();
                            paramMap.put("mona_cd",gookieMap.get("mona_cd"));
                            paramMap.put("result",tempMap2.get("RESULT_VOTE_MOD"));
                            System.out.println((String)tempMap2.get("RESULT_VOTE_MOD"));
                            gookieMapper.insertOpenApi(paramMap);
                        }
                    }
                }

            }catch (Exception e){

            }
        }
        return null;
    }
}
