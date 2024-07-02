package com.insoo.jwk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateCSV {

    public static void main(String[] args) {
        String filePath = "C:/data.csv"; // CSV 파일 경로
        int numRecords = 10; // 생성할 데이터 수

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try (FileWriter writer = new FileWriter(filePath)) {
            // CSV 헤더 작성
            writer.append("ID,FirstName,LastName,Gender,Age,Location,Status,CreatedDate,ModifiedDate\n");

            // 데이터 생성 및 파일에 쓰기
            Random random = new Random();
            for (int i = 1; i <= numRecords; i++) {
                // 랜덤 데이터 생성
                int age = random.nextInt(60) + 20; // 20부터 79까지 나이 생성
                String firstName = generateRandomName();
                String lastName = generateRandomName();
                String gender = random.nextBoolean() ? "M" : "F";
                String location = generateRandomLocation();
                String status = "ONLINE";
                Date currentDate = new Date();
                String createdDate = dateFormat.format(currentDate);
                String modifiedDate = dateFormat.format(currentDate);

                // CSV 라인 작성
                writer.append(i + "," + firstName + "," + lastName + "," + gender + "," + age + "," +
                        location + "," + status + "," + createdDate + "," + modifiedDate + "\n");
            }

            System.out.println("CSV 파일 생성 완료: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 랜덤 이름 생성
    private static String generateRandomName() {
        String[] names = {"Grover", "Hoover", "Alice", "Bob", "Charlie", "David", "Emily", "Fiona", "George", "Hannah"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    // 랜덤 위치 생성
    private static String generateRandomLocation() {
        String[] locations = {"Honolulu", "New York", "Los Angeles", "Chicago", "Houston", "Seattle", "London", "Paris", "Tokyo", "Sydney"};
        Random random = new Random();
        return locations[random.nextInt(locations.length)];
    }
}