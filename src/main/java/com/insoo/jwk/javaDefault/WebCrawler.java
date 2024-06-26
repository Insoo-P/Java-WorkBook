package com.insoo.jwk.javaDefault;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 정적 크롤링 방식
 * 주의점: 해당 루트 주소 + robots.txt로 크롤러에게 접근을 제한하거나 허용하는지 확인하고 가져오기
 * ex: https://www.snu.ac.kr/robots.txt
 */
public class WebCrawler {

    public static void main(String[] args) {
        String url = "https://www.snu.ac.kr/snunow/notice/genernal?sc=y"; // 크롤링할 웹 페이지 URL

        try {
            // Jsoup을 사용하여 웹 페이지에 HTTP GET 요청을 보냄
            Document doc = Jsoup.connect(url).get();
            System.out.println(doc);
//            // 웹 페이지에서 원하는 부분을 선택하여 가져옴 (예: 공지사항 목록)
            Elements rows = doc.select("tbody tr");
            System.out.println(rows);
            // 각 tr 요소에서 제목 가져오기
            for (Element row : rows) {
                // col-title 클래스 안의 span.txt 클래스에 있는 텍스트 가져오기
                String title = row.select(".col-title .txt").text();
                System.out.println("제목: " + title);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
