package com.insoo.jwk.link;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
            // HttpURLConnection 방법
            // responseMap = HttpURLsendRequest(urlString, paramMap);

            // RestTemplate 방법
            responseMap = RestTemplateRequest(urlString, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseMap;
    }

    // HttpURLConnection 방법
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

    // RestTemplate 방법
    private Map<String, Object> RestTemplateRequest(String urlString, Map<String, Object> paramMap) throws Exception {

        // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");

        Gson gson = new Gson();
        String jsonInputString = gson.toJson(paramMap);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonInputString, headers);
        try {
            // 요청 보내고 응답 받기
            ResponseEntity<Map> response = new RestTemplate().postForEntity(urlString, requestEntity, Map.class);

//            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
//                    urlString,
//                    HttpMethod.POST,
//                    requestEntity,
//                    new ParameterizedTypeReference<Map<String, Object>>() {});
            // 응답 출력
            System.out.println("Response Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
            paramMap = response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println("Error: " + e.getStatusCode());
            System.out.println("Error Body: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paramMap;
    }
}
