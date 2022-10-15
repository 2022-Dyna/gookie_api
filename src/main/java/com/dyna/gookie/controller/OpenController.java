package com.dyna.gookie.controller;

import com.dyna.gookie.service.OpenService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/open")
public class OpenController {

    private final OpenService openService;
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
}
