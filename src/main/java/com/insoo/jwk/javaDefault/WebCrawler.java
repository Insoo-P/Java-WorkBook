package com.insoo.jwk.javaDefault;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/**
 * 정적 크롤링 방식
 * 주의점: 해당 루트 주소 + robots.txt로 크롤러에게 접근을 제한하거나 허용하는지 확인하고 가져오기
 * ex: https://www.snu.ac.kr/robots.txt
 */
public class WebCrawler {

    public static void main(String[] args) {
        String url = "https://www.snu.ac.kr/snunow/notice/genernal?sc=y"; // 크롤링할 웹 페이지 URL
        // webStaticCrawler(url);
        webDynamicCrawler(url);

    }

    public static void webStaticCrawler(String url){
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

    public static void webDynamicCrawler(String url){
        // 크롬 드라이버 경로 설정 (본인 환경에 맞게 수정 필요)
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chrome-headless-shell-win64/chrome-headless-shell-win64/chrome-headless-shell.exe");


        // ChromeOptions 설정 (필요에 따라 Headless 모드 등 설정 가능)
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // Headless 모드로 실행할 경우

        // WebDriver 객체 생성 (ChromeDriver 사용)
        WebDriver driver = new ChromeDriver();

        try {

            // 웹 페이지 열기
            driver.get(url);

            // 웹 페이지가 로드될 때까지 잠시 대기 (예: 5초)
            Thread.sleep(5000); // 실제 상황에 맞게 대기 시간을 조정할 필요가 있습니다

            // 원하는 데이터 추출
            // tbody 요소 안의 모든 tr 요소들을 선택
            for (WebElement row : driver.findElements(By.cssSelector("tbody tr"))) {
                // col-title 클래스 안의 span.txt 클래스에 있는 텍스트 가져오기
                String title = row.findElement(By.cssSelector(".col-title .txt")).getText();
                System.out.println("제목: " + title);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
    }

}
