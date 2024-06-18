package com.insoo.jwk.link;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/link/api")
public class LinkApiController {

    @PostMapping("/brno")
    @ResponseBody
    public Map<String, Object> brnoApiRequest(@RequestBody Map<String, Object> paramMap){
        // 요청을 보낼 URL
        String urlString = "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=xqCmt1IwsBOcknFwJPerGVSfexBpw8S%2F%2Flv9z9QjEEabqun4boY3K2yBFgFf9br7MwuyXhpga3Wzc1FcfT%2FnnA%3D%3D";
        Map<String, Object> responseMap = null;
        // 요청 보내기
        try {
            responseMap = HttpURLsendRequest(urlString, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseMap;
    }

    private Map<String, Object> HttpURLsendRequest(String urlString, Map<String, Object> paramMap) throws Exception {
        // URL 객체 생성
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 요청 메소드 및 헤더 설정
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true); // OutputStream을 사용하기 위해 true로 설정

        // Gson 객체 생성
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(paramMap);

        // 요청 본문 작성
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // 응답 코드 확인
        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        // 응답 읽기
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Response :: " + response.toString());
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = null;

            try {
                responseMap = objectMapper.readValue(response.toString(), Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return responseMap;
        }
    }

}
