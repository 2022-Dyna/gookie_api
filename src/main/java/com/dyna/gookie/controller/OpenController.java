package com.dyna.gookie.controller;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OpenController {

    private final String key = "451d44aa30cf47b5b3d2a3eca536ec41";

    @GetMapping()
    public void clinicInformation(@RequestParam(value = "Type", defaultValue = "json") String Type,
                                  @RequestParam(value = "pIndex", defaultValue = "1") int pIndex,
                                  @RequestParam(value = "pSize", defaultValue = "10") int pSize,
                                  @RequestParam(value = "UNIT_CD", defaultValue = "100021") int UNIT_CD){
        String result = "";
        try {
            URL url = new URL("https://open.assembly.go.kr/portal/openapi/npffdutiapkzbfyvr?KEY="+key+"&Type="+Type+"&pIndex="+pIndex+"&pSize="+pSize+"&UNIT_CD="+UNIT_CD);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);

            System.out.println(jsonObject);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
