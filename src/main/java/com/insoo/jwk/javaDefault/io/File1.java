package com.insoo.jwk.javaDefault.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class File1 {

    private static String url = "C:/Users/User/Desktop";

    public static void main(String[] args) {

        // 파일, 폴더 만들기
        File dirmk = new File(url+"/fileIo/fileMkdir");
        File filemk = new File(url+"/fileIo/fileMkdir/filemkTest.txt");
        File filemk2 = new File(url+"/fileIo/fileMkdir/filemkTest2.txt");
        if(!dirmk.exists()){
            if(dirmk.mkdirs()){
                System.out.println("#### 폴더 생성 완료");
            };
        };
        if(!filemk.exists()){
            try {
                if(filemk.createNewFile()){
                    System.out.println("#### 파일 생성 완료 - 파일명 : " + filemk.getName());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        try{
            if(filemk2.createNewFile()){
                System.out.println("#### 파일 생성 완료");
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        File[] files = dirmk.listFiles();

        assert files != null;
        Arrays.stream(files)
                .toList()
                .forEach(v -> System.out.println("#### fileIo에 있는 file : " + v.getName()));

        System.out.println("#### getAbsoluteFile : " + filemk.getAbsoluteFile());
        System.out.println("#### getAbsolutePath : " + filemk.getAbsolutePath());
    }
}
